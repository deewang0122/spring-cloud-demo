package com.dee.basekit.mvc.login;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserToken implements IUserToken, Serializable {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 附件属性
     */
    //private Map<String, ObjectMapper> extProperties;

    @Override
    public String getUserId() {
        return this.getId();
    }

    @Override
    public String getUserName() {
        return this.getName();
    }

//    @Override
//    public ObjectMapper getExtProperty(String key) {
//        return this.getExtProperties() != null ? this.getExtProperties().get(key) : null;
//    }
//
//    @Override
//    public ObjectMapper getExtProperty(String key, ObjectMapper defaultValue) {
//        return (this.getExtProperties() != null) ? this.getExtProperties().get(key) : defaultValue;
//    }

}
