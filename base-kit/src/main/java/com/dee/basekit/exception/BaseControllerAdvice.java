package com.dee.basekit.exception;

import com.dee.basekit.mvc.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常基类
 */
public abstract class BaseControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler({GlobalException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> globalException(GlobalException exception) {
        logger.error(exception.getMessage(), exception);
        return Result.fail(exception);
    }

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> runtimeException(RuntimeException exception) {
        logger.error(exception.getMessage(), exception);
        return Result.fail(exception);
    }

}
