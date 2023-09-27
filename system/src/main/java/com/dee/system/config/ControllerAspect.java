package com.dee.system.config;

import com.dee.basekit.config.ContextHolder;
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
public class ControllerAspect {

    @Pointcut("execution(public * com.dee.wang.controller.*Controller.*(..))")
    public void pointCut1() {

    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointCut() {

    }

    @After("pointCut() && pointCut1()")
    public void doAfter() {
        log.info("doAfter.........");
        ContextHolder.clear();
        HttpContextHolder.clear();
    }
}
