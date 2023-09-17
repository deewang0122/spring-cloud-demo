package com.dee.basekit.config;

import com.dee.basekit.constant.Constants;
import com.dee.basekit.mvc.domain.UserToken;
import com.dee.basekit.util.SessionUtils;

import java.util.Objects;

/**
 * 登录组件：登录用户信息
 */
public interface LoginComponent {
    static String getUserId() {
        return getUserToken().getUserId();
    }

    static String getUserName() {
        return getUserToken().getUserName();
    }

    static UserToken getUserToken() {
        Object obj = GlobalRedisManager.get(Objects.requireNonNull(SessionUtils.getRequest()).getHeader(Constants.HTTP_HEADER_AUTHORIZATION));
        return (UserToken) obj;
    }
}
