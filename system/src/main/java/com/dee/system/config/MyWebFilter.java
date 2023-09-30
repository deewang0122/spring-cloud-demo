package com.dee.system.config;

import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public interface MyWebFilter extends Ordered {
    Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain);

    default int getOrder() {
        return 0;
    }
}