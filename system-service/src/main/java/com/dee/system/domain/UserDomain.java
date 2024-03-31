package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.enums.UserEnum;
import com.dee.system.global.BaseGlobalDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true) //生成equals/hashCode方法时包含其父类的属性
@Data
@TableName("system_user")
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain extends BaseGlobalDomain {
    @TableField("name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("password")
    private String password;

    @TableField("type")
    private Integer type;

    @TableField("status")
    private Integer status = UserEnum.STATUS_ENABLE.getKey();

    @TableField("remark")
    private String remark;

    @TableField("is_admin")
    private Integer isAdmin;

}
