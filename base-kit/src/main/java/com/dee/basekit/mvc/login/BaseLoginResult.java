package com.dee.basekit.mvc.login;

public abstract class BaseLoginResult {
    /**
     * 登录成功返回token
     */
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
