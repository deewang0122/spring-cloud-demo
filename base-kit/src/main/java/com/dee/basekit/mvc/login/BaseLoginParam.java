package com.dee.basekit.mvc.login;

public abstract class BaseLoginParam {
    /**
     * 登录账号
     */
    private String account;
    /**
     * 登录密码
     */
    private String password;

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
