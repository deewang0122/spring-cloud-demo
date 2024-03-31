package com.dee.system.param;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class MenuAddParam {
    private String name;

    private String url;

    private String parentId = "-1";

    private Integer sort = 1;

    private String icon;

    private Integer isClick = 1;

    private Integer isCurrentPage = 1;

    private String remark;
}
