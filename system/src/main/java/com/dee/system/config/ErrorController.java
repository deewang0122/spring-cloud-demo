package com.dee.system.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
// https://zhuanlan.zhihu.com/p/344878241
@ControllerAdvice
public class ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ResponseBody
    @ExceptionHandler({NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String nullException(NullPointerException e) {
        logger.error("global err handler", e);
        return "{\"msg\":\"There is a problem\"}";
    }

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String runtimeException(RuntimeException e) {
        logger.error("global err handler", e);
        return "{\"msg\":\"There is a problem\"}";
    }
}