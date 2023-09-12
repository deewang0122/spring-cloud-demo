package com.dee.basekit.mvc.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface IUserToken {
    String getUserId();

    String getUserName();

    ObjectMapper getExtProperty(String key);

    ObjectMapper getExtProperty(String key, ObjectMapper defaultValue);
}
