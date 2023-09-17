package com.dee.system.controller;

import com.dee.basekit.config.GlobalRedisManager;
import com.dee.basekit.mvc.param.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "demo")
public class TestController {

    @GetMapping("/test")
    public Result<String> test() {
        String name = String.valueOf(System.currentTimeMillis());
        String value = GlobalRedisManager.get("testKey").toString();
        return Result.success("test 地址 : " + name + "testKey = " + value);

    }

    @GetMapping("/test1")
    public Result<String> test(String name) {
        String value = GlobalRedisManager.get("testKey").toString();
        return Result.success("test 地址 : " + name + "testKey = " + value);
    }

    @GetMapping("/test3")
    public Mono<Result<String>> test3(String name) {
        String value = GlobalRedisManager.get("testKey").toString();
        return Mono.justOrEmpty(Result.success(value));
    }

}
