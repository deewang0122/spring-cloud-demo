package com.dee.system.controller;

import com.dee.basekit.mvc.param.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demo")
public class TestController {


    @GetMapping("/test")
    public Result test(String name) {
        return Result.success("test 地址 : " + name);
    }

}
