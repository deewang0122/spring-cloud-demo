package com.dee.basekit.mvc.login;

import lombok.Data;

@Data
public abstract class BaseLoginParam {
    /**
     * 登录账号
     */
    private String account;
    /**
     * 登录密码
     */
    private String password;

}
