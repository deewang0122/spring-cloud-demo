//package com.dee.learning.client;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.support.WebClientAdapter;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//
//@Configuration
//public class WebConfigClient {
//    @Bean
//    WebClient webClient() {
//        return WebClient.builder()
//                .baseUrl("http://localhost:8030")
//                .build();
//    }
//
//    @Bean
//    ITestService iTestService() {
//        HttpServiceProxyFactory httpServiceProxyFactory =
//                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient()))
//                        .build();
//        return httpServiceProxyFactory.createClient(ITestService.class);
//    }
//
//}
