package com.dee.basekit.config;

import com.dee.basekit.constant.Constants;
import com.dee.basekit.mvc.login.UserToken;
import org.springframework.data.util.CastUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * 登录组件：登录用户信息
 */
public abstract class LoginComponent {
    public static String getToken() {
        ServerHttpRequest serverHttpRequest = CastUtils.cast(HttpContextHolder.getItem(Constants.SESSION_CURRENT_REQUEST));
        return serverHttpRequest.getHeaders().getFirst(Constants.HTTP_HEADER_AUTHORIZATION);
    }

    public static String getUserId() {
        return getUserToken().getUserId();
    }

    public static String getUserName() {
        return getUserToken().getUserName();
    }

    public static UserToken getUserToken() {
        return CastUtils.cast(HttpContextHolder.getItem(Constants.SESSION_CURRENT_USER_TOKEN));
    }
}
