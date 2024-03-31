package com.dee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@MapperScan("com.dee.system.mapper")
@SpringBootApplication
public class SystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class, args);
    }

}
