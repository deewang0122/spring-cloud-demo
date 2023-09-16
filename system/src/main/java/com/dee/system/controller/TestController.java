package com.dee.system.controller;

import com.dee.basekit.config.GlobalRedisManager;
import com.dee.basekit.mvc.param.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demo")
public class TestController {

//    @Value("${server_test.port_test}")
//    private String testKey;
    @GetMapping("/test")
    public Result test(String name) {

        GlobalRedisManager.set("testKey", "testValue" + System.currentTimeMillis());
        String value = GlobalRedisManager.get("testKey").toString();
        return Result.success("test 地址 : " + name + "testKey = " + value);

    }

}
