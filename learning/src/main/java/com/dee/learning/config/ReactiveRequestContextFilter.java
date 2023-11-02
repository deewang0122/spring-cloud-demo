package com.dee.learning.config;

import com.dee.basekit.config.GlobalRedisManager;
import com.dee.basekit.config.HttpContextHolder;
import com.dee.basekit.constant.Constants;
import com.dee.basekit.mvc.login.UserToken;
import com.dee.basekit.util.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class ReactiveRequestContextFilter implements WebFilter {

    @SuppressWarnings("NullableProblems")
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        // 获取Request
        ServerHttpRequest serverHttpRequest = serverWebExchange.getRequest();
        // 获取Token, 默认从Gateway访问，默认认证通过
        val authorization = serverHttpRequest.getHeaders().getFirst(Constants.HTTP_HEADER_AUTHORIZATION);
        // 查询用户信息
        UserToken userToken = ObjectUtils.copyObject(GlobalRedisManager.get(authorization), new UserToken());
        // 存放当前用户信息
        HttpContextHolder.setItem(Constants.SESSION_CURRENT_USER_TOKEN, userToken);
        // 存放HttpRequest
        HttpContextHolder.setItem(Constants.SESSION_CURRENT_REQUEST, serverHttpRequest);
        // 存放HttpResponse
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        HttpContextHolder.setItem(Constants.SESSION_CURRENT_RESPONSE, serverHttpResponse);

        return webFilterChain.filter(serverWebExchange).doFinally(exchange -> {
            HttpContextHolder.clear();
        });
    }



}
