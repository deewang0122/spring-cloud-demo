package com.dee.basekit.mvc.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Result<T> {
    private static final Integer SUCCESS_CODE = 1;
    private static final Integer FAIL_CODE = 0;
    private static final String SUCCESS_MESSAGE = "Success";
    private static final String FAIL_MESSAGE = "Fail";
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(FAIL_CODE, message, null);
    }

    public static <T> Result<T> fail(Throwable cause) {
        return new Result<>(FAIL_CODE, cause.getLocalizedMessage(), null);
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
