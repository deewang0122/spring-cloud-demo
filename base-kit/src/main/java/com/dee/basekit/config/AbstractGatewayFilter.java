package com.dee.basekit.config;

import com.dee.basekit.constant.Constants;
import com.dee.basekit.mvc.login.UserToken;
import com.dee.basekit.util.BcryptUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.util.CastUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class AbstractGatewayFilter extends AbstractFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 检查白名单
        if (verifyWhitelist(exchange.getRequest().getPath().toString())) {
            return chain.filter(exchange);
        }

        val authorization = getAuthorization(exchange.getRequest());
        // 1. 检查认证信息存在
        if (!StringUtils.hasText(authorization)) {
            exchange.getResponse().setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            return exchange.getResponse().setComplete();
        }
        // 2. 校验认证信息
        if (!GlobalRedisManager.hasKey(authorization)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // 3. 校验token
        if (!verifyToken(authorization)) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
        // 4. 刷新token
        refreshToken(authorization);

        return chain.filter(exchange);
    }

    protected boolean verifyWhitelist(String requestPath) {
        return false;
    }

    private void refreshToken(String authorization) {
        GlobalRedisManager.expire(authorization, getExpireTime());
    }

    private boolean verifyToken(String authorization) {
        Object object = GlobalRedisManager.get(authorization);
        UserToken userToken = CastUtils.cast(object);
        return BcryptUtils.matches(initUserTokenKey(userToken), authorization);
    }

    private String initUserTokenKey(UserToken userToken) {
        return userToken.getUserId() + userToken.getUserName();
    }

    private String getAuthorization(ServerHttpRequest request) {
        return request.getHeaders().getFirst(Constants.HTTP_HEADER_AUTHORIZATION);
    }

    @Override
    public int getOrder() {
        // 优先执行：defaultFilter, 路由过滤器
        return Integer.MAX_VALUE;
    }

}
