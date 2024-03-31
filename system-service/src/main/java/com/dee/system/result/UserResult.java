package com.dee.system.result;

import com.dee.system.enums.UserEnum;
import lombok.Data;

@Data
public class UserResult {
    String id;

    private String name;

    private String code;

    private String email;

    private Integer status;

    private String statusName;

    private String remark;

    private String isAdmin;

    public String getStatusName() {
        return UserEnum.instance(this.status).getValue();
    }
}
