package com.dee.learning.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    ISystemService iSystemService() {
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(WebClient.builder().baseUrl("http://127.0.0.1:8030/system").build()))
                .blockTimeout(Duration.ofSeconds(60))
                .build();

        return proxyFactory.createClient(ISystemService.class);
    }
}
