package com.dee.basekit.config;

import com.dee.basekit.constant.Constants;
import com.dee.basekit.mvc.login.UserToken;
import org.springframework.data.util.CastUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * 登录组件：登录用户信息
 */
public interface LoginComponent {
    static String getToken() {
        ServerHttpRequest serverHttpRequest = CastUtils.cast(HttpContextHolder.getItem(Constants.SESSION_CURRENT_REQUEST));
        return serverHttpRequest.getHeaders().getFirst(Constants.HTTP_HEADER_AUTHORIZATION);
    }

    static String getUserId() {
        return getUserToken().getUserId();
    }

    static String getUserName() {
        return getUserToken().getUserName();
    }

    static UserToken getUserToken() {
        return CastUtils.cast(ContextHolder.getItem(Constants.SESSION_CURRENT_USER));
    }
}
