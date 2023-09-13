package com.dee.learning.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class TestConfig {
    @Bean
    public TestObj testObj2() {
        TestObj testObj = new TestObj();
        testObj.setCode("codeTest2");
        testObj.setName("编码2");
        return testObj;
    }
    @Bean
    public TestObj testObj() {
        TestObj testObj = new TestObj();
        testObj.setCode("codeTest");
        testObj.setName("编码");
        return testObj;
    }


}
