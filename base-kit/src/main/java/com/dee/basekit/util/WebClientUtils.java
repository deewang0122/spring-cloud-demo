package com.dee.basekit.util;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;

public class WebClientUtils {

    public static <T> T syncGetMono(WebClient webClient, String url, Class<T> resClass) {
        return webClient.get().uri(url).retrieve().bodyToMono(resClass).block();
    }

    public static <T> Collection<T> syncGetFlux(WebClient webClient, String url, Class<T> resClass) {
        return webClient.get().uri(url).retrieve().bodyToFlux(resClass).buffer().blockFirst();
    }

    public static <T> T syncPostMono(WebClient webClient, String url, Class<T> resClass) {
        return webClient.post().uri(url).retrieve().bodyToMono(resClass).block();
    }

    public static <T> Collection<T> syncPostFlux(WebClient webClient, String url, Class<T> resClass) {
        return webClient.post().uri(url).retrieve().bodyToFlux(resClass).buffer().blockFirst();
    }

    public static <T> Collection<T> syncPostFlux11(WebClient webClient, String url, Class<T> resClass) {
        WebClient client = WebClient.create("https://example.org");

        return webClient.get().uri("/persons").retrieve()
                .bodyToFlux(resClass)
                .collectList()
                .block();
    }
}
