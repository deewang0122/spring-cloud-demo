package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.global.BaseGlobalDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("system_tenant_role")
@NoArgsConstructor
public class TenantRoleDomain extends BaseGlobalDomain {
    @TableField("tenant_id")
    private String tenantId;

    @TableField("role_id")
    private String roleId;

    @TableField("status")
    private Integer status;

}
