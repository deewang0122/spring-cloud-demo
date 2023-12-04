package com.dee.learning.exception;

import com.dee.basekit.exception.GlobalException;

/**
 * 异常捕获
 *
 * @author dee
 */
public class LearningException extends GlobalException {
    public LearningException() {
        super();
    }

    public LearningException(String message) {
        super(message);
    }

    public LearningException(String message, Throwable cause) {
        super(message, cause);
    }

    public LearningException(Throwable cause) {
        super(cause);
    }

    protected LearningException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
