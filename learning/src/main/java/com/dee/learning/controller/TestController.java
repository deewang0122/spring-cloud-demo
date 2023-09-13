package com.dee.learning.controller;

import com.dee.learning.client.TestObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demo")
public class TestController {

    @Autowired
    private TestObj testObj;

    @GetMapping(value = "test1")
    public String test() {
        return testObj.getName() + ": " + testObj.getCode();
    }

//    @Autowired
//    private ITestService iTestService;
//
//    @GetMapping("/test")
//    public Result<String> test(String name) {
//        return Result.success("test 地址 : " + name);
//    }
//
//    @GetMapping("/feign")
//    public Result<String> feign(String name) {
//        return iTestService.test(name);
//    }

}
