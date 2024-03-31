package com.dee.learning.client;

import com.dee.basekit.mvc.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class CompletableFutureClient {
    @Autowired
    ISystemService systemService;
    @SuppressWarnings("unchecked")
    public Result<String> test(String token){
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
            return systemService.test(token);
        });
        try {
            return (Result<String>) completableFuture.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
