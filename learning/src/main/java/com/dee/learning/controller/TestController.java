package com.dee.learning.controller;

import com.dee.basekit.mvc.param.Result;
import com.dee.basekit.util.ObjectUtils;
import com.dee.learning.client.ITestService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "demo")
@Slf4j
public class TestController {
    @Autowired
    private ITestService iTestService;

    @GetMapping("/test")
    public Result<String> test(String name) {
        return Result.success("test 地址 : " + name);
    }

    @GetMapping("/feign")
    public Result<String> feign(String name) {
        return Result.success("feign 地址 : " + iTestService.test());
    }

    @GetMapping("/feign1")
    public Mono<Result<String>> feign1(String name) {
//        return Result.success("feign 地址 : " + iTestService.test1(name));
        return Mono.just(iTestService.test1(name));
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
