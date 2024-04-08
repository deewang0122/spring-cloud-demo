package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.enums.RoleRelationEnum;
import com.dee.system.enums.StatusEnum;
import com.dee.system.global.BaseGlobalDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("system_role_relation")
@NoArgsConstructor
public class RoleRelationDomain extends BaseGlobalDomain {
    @TableField("relation_id")
    private String relationId;

    @TableField("role_id")
    private String roleId;

    @TableField("type")
    private RoleRelationEnum type;

    @TableField("status")
    private StatusEnum status;

}
