package com.dee.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.dee.system.enums.StatusEnum;
import com.dee.system.global.BaseGlobalDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true) //生成equals/hashCode方法时包含其父类的属性
@Data
@TableName("system_menu")
@NoArgsConstructor
@AllArgsConstructor
public class MenuDomain extends BaseGlobalDomain {
    @TableField("component")
    private String component;

    @TableField("parent_id")
    private String parentId = "-1";

    @TableField("name")
    private String name;

    @TableField("path")
    private String path;

    @TableField("redirect")
    private String redirect;

    @TableField("status")
    private StatusEnum status;

    @TableField("sort")
    private Integer sort = 1;

    @TableField("remark")
    private String remark;

    @TableField(value = "meta", typeHandler = JacksonTypeHandler.class)
    private Meta meta;

    @TableField(value = "button_list", typeHandler = JacksonTypeHandler.class)
    private List<Button> buttonList;

    @Data
    static class Button {
        String label;

        String value;
    }

    @Data
    static class Meta {
        String icon;

        String title;
    }
}
