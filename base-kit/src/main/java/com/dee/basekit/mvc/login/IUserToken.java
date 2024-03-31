package com.dee.basekit.mvc.login;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * userToken 接口
 */
public interface IUserToken {
    /**
     * 获取当前登录用户ID
     *
     * @return userID
     */
    String getUserId();

    String getUserName();

    String getTenantId();

    String getTenantName();

    boolean isAdmin();

    Object getExtProperty(String key);

    Object getExtProperty(String key, ObjectMapper defaultValue);
}
