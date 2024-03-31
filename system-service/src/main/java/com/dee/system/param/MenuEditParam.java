package com.dee.system.param;

import lombok.Data;

@Data
public class MenuEditParam {
    private String id;

    private String name;

    private String url;

    private Integer sort = 1;

    private String icon;

    private Integer isClick = 1;

    private Integer isCurrentPage = 1;

    private String remark;
}
