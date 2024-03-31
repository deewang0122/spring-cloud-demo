package com.dee.system.param;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserSaveParam {
    @NotEmpty(message = "用户名称不能为空！")
    String name;

    @NotEmpty(message = "用户编码不能为空！")
    String code;

    @Email(message = "邮箱不能为空！")
    String email;

    String type;

    String remark;

}
