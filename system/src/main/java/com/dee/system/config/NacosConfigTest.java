package com.dee.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/config")
public class NacosConfigTest {

    @Value(value = "${server_test.port_test:}")
    private String testKey;

    @RequestMapping(value = "/get")
    public String getConfig() {
        return testKey + ":" + testKey;
    }
}
