package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private Integer status;

    @TableField("sort")
    private Integer sort = 1;

    @TableField("remark")
    private String remark;

}
