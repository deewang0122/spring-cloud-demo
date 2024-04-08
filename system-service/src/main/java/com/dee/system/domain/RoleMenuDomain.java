package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.enums.StatusEnum;
import com.dee.system.global.BaseGlobalDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true) //生成equals/hashCode方法时包含其父类的属性
@Data
@TableName("system_role_menu")
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuDomain extends BaseGlobalDomain {
    @TableField("role_id")
    private String roleId;

    @TableField("menu_id")
    private String menuId;

    @TableField("status")
    private StatusEnum status;

}
