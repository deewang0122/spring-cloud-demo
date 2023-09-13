package com.dee.basekit.mvc.controller;

import com.dee.basekit.config.GlobalRedisManager;
import com.dee.basekit.mvc.domain.UserToken;
import com.dee.basekit.util.SessionUtils;
// TODO...2023/9/11: 待优化
public abstract class BaseController {
    private static final String AUTHORIZATION = "Authorization";
    protected static String getUserId() {
        return getUserToken().getUserId();
    }

    protected static String getUserName() {
        return getUserToken().getUserName();
    }

    protected static UserToken getUserToken() {
        Object obj = GlobalRedisManager.get(SessionUtils.getRequest().getHeader(AUTHORIZATION));
        return (UserToken) obj;
    }
}
