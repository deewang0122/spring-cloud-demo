package com.dee.learning.client;

import com.dee.basekit.mvc.param.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(value = "/demo")
public interface ITestService {
    @GetExchange(value = "/test")
    Result<String> test();

    @GetExchange(value = "/test1")
    Result<String> test1(@RequestParam String name);

    @GetExchange(value = "/test1")
    Mono<Result<String>> test2(@RequestParam String name);

    @GetExchange(value = "/test3")
    Mono<Result<String>> test3(@RequestParam String name);
}
