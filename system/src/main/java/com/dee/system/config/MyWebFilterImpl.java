package com.dee.system.config;

import com.dee.basekit.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyWebFilterImpl implements MyWebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 在这里可以对请求和响应进行修改
        log.info(request.getHeaders().get(Constants.HTTP_HEADER_AUTHORIZATION).toString());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}