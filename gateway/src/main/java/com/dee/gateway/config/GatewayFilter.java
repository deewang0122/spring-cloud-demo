package com.dee.gateway.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GatewayFilter implements GlobalFilter, Ordered {
    @Resource
    private RedisTemplate redisTemplate;
    private static final String AUTHORIZATION = "Authorization";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final val authorization = getAuthorization(exchange.getRequest());
        // 1. 检查认证信息存在
        if (!StringUtils.hasText(authorization)) {
            exchange.getResponse().setStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            return exchange.getResponse().setComplete();
        }
        // 2. 校验认证信息
        if (!redisTemplate.hasKey(authorization)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    private String getAuthorization(ServerHttpRequest request) {
        return request.getHeaders().getFirst(AUTHORIZATION);
    }

    @Override
    public int getOrder() {
        // 优先执行：defaultFilter, 路由过滤器
        return Integer.MAX_VALUE;
    }
}
