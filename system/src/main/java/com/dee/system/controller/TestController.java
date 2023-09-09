package com.dee.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "demo")
public class TestController {


    @GetMapping("/test")
    public String queryDemo(String name) {
        return "test 地址 : " + name;
    }

}
