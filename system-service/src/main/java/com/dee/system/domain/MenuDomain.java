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
@TableName("system_menu")
@NoArgsConstructor
@AllArgsConstructor
public class MenuDomain extends BaseGlobalDomain {
    @TableField("name")
    private String name;

    @TableField("url")
    private String url;

    @TableField("status")
    private Integer status = 1;

    @TableField("parent_id")
    private String parentId = "-1";

    @TableField("level")
    private Integer level = 0;

    @TableField("sort")
    private Integer sort = 1;

    @TableField("icon")
    private String icon;

    @TableField("is_click")
    private Integer isClick = 1;

    @TableField("is_current_page")
    private Integer isCurrentPage = 1;

    @TableField("remark")
    private String remark;

}
