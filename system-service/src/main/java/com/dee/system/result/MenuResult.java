package com.dee.system.result;

import lombok.Data;

import java.util.List;

@Data
public class MenuResult {
    private String id;

    private String name;

    private String url;

    private String parentId;

    private Integer level = 0;

    private String icon;

    private String remark;

    private List<MenuResult> children;
}
