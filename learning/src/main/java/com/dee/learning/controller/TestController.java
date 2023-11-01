package com.dee.learning.controller;

import com.dee.basekit.config.LoginComponent;
import com.dee.basekit.mvc.param.Result;
import com.dee.learning.client.CompletableFutureClient;
import com.dee.learning.client.ISystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        // 跨服务调用测试
        return completableFutureClient.test(LoginComponent.getToken());
    }

}
