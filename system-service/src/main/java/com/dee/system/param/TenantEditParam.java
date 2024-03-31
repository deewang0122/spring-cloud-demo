package com.dee.system.param;

import lombok.Data;

@Data
public class TenantEditParam {
    private String id;

    private String name;

    private Integer sort = 1;

    private String remark;

}
