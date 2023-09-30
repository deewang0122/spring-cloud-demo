package com.dee.basekit.config;

import com.dee.basekit.config.ContextHolder;
import com.dee.basekit.constant.Constants;
import com.dee.basekit.mvc.login.UserToken;
import org.springframework.data.util.CastUtils;

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
        return CastUtils.cast(ContextHolder.getItem(Constants.SESSION_CURRENT_USER));
    }
}
