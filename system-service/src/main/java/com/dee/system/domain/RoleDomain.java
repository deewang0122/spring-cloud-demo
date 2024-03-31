package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.global.BaseGlobalDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true) //生成equals/hashCode方法时包含其父类的属性
@Data
@TableName("system_role")
@NoArgsConstructor
@AllArgsConstructor
public class RoleDomain extends BaseGlobalDomain {
    @TableField("user_id")
    private String name;

    @TableField("status")
    private Integer status = 1;

    @TableField("sort")
    private Integer sort = 1;

    @TableField("remark")
    private String remark;

}
