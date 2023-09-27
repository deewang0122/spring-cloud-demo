package com.dee.basekit.util;

import com.dee.basekit.config.HttpContextHolder;
import com.dee.basekit.constant.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SessionUtils {
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) HttpContextHolder.getItem(Constants.SESSION_CURRENT_REQUEST);
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) HttpContextHolder.getItem(Constants.SESSION_CURRENT_RESPONSE);
    }
}
