package com.dee.system;

import com.dee.system.config.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableFeignClients
@SpringBootApplication
@EnableJpaAuditing
@EnableWebFlux
//@ServletComponentScan
public class SystemApplication {
    @Bean
    public FilterRegistrationBean<MyFilter> getFilter() {
        FilterRegistrationBean<MyFilter> filter = new FilterRegistrationBean<MyFilter>(new MyFilter());
        return filter;

    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("myFilter");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
