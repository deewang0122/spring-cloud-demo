package com.dee.basekit.mvc.login;

import lombok.Data;

@Data
public abstract class BaseLoginResult {
    /**
     * 登录成功返回token
     */
    private String token;

}
