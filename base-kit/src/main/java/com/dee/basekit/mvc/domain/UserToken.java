package com.dee.basekit.mvc.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Map;

@Data
public class UserToken implements IUserToken {
    private String id;
    private String name;

    private Map<String, ObjectMapper> extProperties;

    @Override
    public String getUserId() {
        return this != null ? this.getId() : null;
    }

    @Override
    public String getUserName() {
        return this != null ? this.getName() : null;
    }

    @Override
    public ObjectMapper getExtProperty(String key) {
        return (this != null && this.getExtProperties() != null) ? this.getExtProperties().get(key) : null;
    }

    @Override
    public ObjectMapper getExtProperty(String key, ObjectMapper defaultValue) {
        return (this != null && this.getExtProperties() != null) ? this.getExtProperties().get(key) : defaultValue;
    }

}
