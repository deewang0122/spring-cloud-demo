package com.dee.system.config;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@Component
@Slf4j
//@WebFilter(value = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init----------------------------");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter----------------------------");
    }

    @Override
    public void destroy() {
        log.info("destroy----------------------------");
        Filter.super.destroy();
    }
}
