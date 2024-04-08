package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dee.system.enums.StatusEnum;
import com.dee.system.enums.TenantEnum;
import com.dee.system.global.BaseGlobalDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("system_tenant")
@NoArgsConstructor
public class TenantDomain extends BaseGlobalDomain {
    @TableField("name")
    private String name;

    @TableField("status")
    private StatusEnum status;

    @TableField("sort")
    private Integer sort = 1;

    @TableField("parent_id")
    private String parentId = "-1";

    @TableField("type")
    private TenantEnum type = TenantEnum.TYPE_DEFAULT;

    @TableField("remark")
    private String remark;

}
