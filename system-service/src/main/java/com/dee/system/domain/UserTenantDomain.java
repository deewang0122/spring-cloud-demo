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
@TableName("system_user_tenant")
@NoArgsConstructor
@AllArgsConstructor
public class UserTenantDomain extends BaseGlobalDomain {
    @TableField("user_id")
    private String userId;

    @TableField("tenant_id")
    private String tenantId;

    @TableField("is_default")
    private Integer isDefault;

    @TableField("status")
    private StatusEnum status = StatusEnum.DEFAULT;

}
