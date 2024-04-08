package com.dee.system.result;

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

}
