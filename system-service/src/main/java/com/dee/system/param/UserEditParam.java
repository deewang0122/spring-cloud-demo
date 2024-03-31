package com.dee.system.param;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserEditParam {
    @NotEmpty(message = "编辑用户ID不能为空！")
    String id;

    String name;

    String code;

    String email;

    String type;

    String remark;

}
