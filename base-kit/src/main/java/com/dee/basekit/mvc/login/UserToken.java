package com.dee.basekit.mvc.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

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
     * 租户Id
     */
    private String tenantId;
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 是否管理员
     */
    private Integer isAdmin;
    /**
     * 附加属性
     */
    private Map<String, Object> extProperties;

    @Override
    public String getUserId() {
        return this.getId();
    }

    @Override
    public String getUserName() {
        return this.getName();
    }

    @Override
    public boolean isAdmin() {
        return Objects.nonNull(this.isAdmin) && 1 == this.isAdmin;
    }

    @Override
    public Object getExtProperty(String key) {
        return this.getExtProperties() != null ? this.getExtProperties().get(key) : null;
    }

    @Override
    public Object getExtProperty(String key, ObjectMapper defaultValue) {
        return (this.getExtProperties() != null) ? this.getExtProperties().get(key) : defaultValue;
    }

}
