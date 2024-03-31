package com.dee.basekit.mvc.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public abstract class BaseLoginParam {
    /**
     * 登录账号
     */
    @NotEmpty(message = "登录账号不能为空")
    private String username;
    /**
     * 登录密码
     */
    @NotEmpty(message = "登录密码不能为空")
    private String password;

}
