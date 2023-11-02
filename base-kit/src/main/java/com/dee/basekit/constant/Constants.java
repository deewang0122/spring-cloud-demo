package com.dee.basekit.constant;

import org.springframework.http.server.reactive.ServerHttpRequest;

public final class Constants {
    /**
     * Token过期时间
     */
    public static final long EXPIRE_TIME = 3600L;
    /**
     * Http Header头部认证信息标识
     */
    public static final String HTTP_HEADER_AUTHORIZATION = "Authorization";
    /**
     * 当前用户会话标识
     */
    public static final String SESSION_CURRENT_USER_TOKEN = "currentUser";
    /**
     * 当前用户会话标识
     */
    public static final String SESSION_CURRENT_REQUEST = "currentRequest";
    /**
     * 当前用户会话标识
     */
    public static final String SESSION_CURRENT_RESPONSE = "currentResponse";
    /**
     * HttpServerRequest
     */
    public static final Class<ServerHttpRequest> SERVER_HTTP_REQUEST_CLASS = ServerHttpRequest.class;
}
