package com.dee.learning.controller;

import com.dee.basekit.mvc.param.Result;
import com.dee.basekit.util.ObjectUtils;
import com.dee.basekit.util.WebClientUtils;
import com.dee.learning.client.CompletableFutureClient;
import com.dee.learning.client.ISystemService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "demo")
@Slf4j
public class TestController {
    @Autowired
    private ISystemService iTestService;

    @Autowired
    CompletableFutureClient completableFutureClient;


    @GetMapping("/test")
    public Result<String> test(String name) {
        return Result.success("test 地址 : " + name);
    }

    @GetMapping("/feign")
    public Result<String> feign(String name) {
        return completableFutureClient.test("testKey");
    }

    @GetMapping("/feign1")
    public Result<String> feign1(String name) {
        WebClient client = WebClient.create("http://127.0.0.1:8030/system");
        Result<String> result = WebClientUtils.syncGetMono(client, "/demo/test1", Result.class);

        return Result.success(result.getData());
    }


    @GetMapping("/feign2")
    public Result<String> feign2(String name) {
        val resultMono = iTestService.test2(name);
        resultMono.subscribe(stringResult -> {
            log.info("toProcessor block :{}", stringResult);
        });

        return Result.success("feign 地址 : " + ObjectUtils.toJson(resultMono.block()));
    }

    @GetMapping("/feign3")
    public Mono<Result<String>> feign3(String name) {

        return Mono.justOrEmpty(iTestService.test3(name).block());
    }

    @GetMapping("/feign4")
    public Result<String> feign4(String name) {

        return iTestService.test3(name).block();
    }

}
