package com.dee.config;

import com.dee.basekit.config.HttpContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Controller层Aop切面编程
 */
@Aspect
@Component
@Slf4j
@Deprecated(since = "20231008")
public class ControllerAspect {

    @Pointcut("execution(* com.dee.wang.controller.*.*(..))")
    public void pointCut1() {

    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointCut() {

    }

    @After("pointCut() && pointCut1()")
    public void doAfter() {
        log.info("doAfter.........");
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooo");
        HttpContextHolder.clear();
    }
}
