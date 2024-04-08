package com.dee.system.result;

import com.dee.basekit.mvc.ITreeModel;
import lombok.Data;

import java.util.List;

@Data
public class MenuListTreeResult implements ITreeModel<MenuListTreeResult> {
    private String id;

    private String parentId;

    private String component;

    private String name;

    private String path;

    private String redirect;

    private MetaResult meta;

    private List<MenuListTreeResult> children;

    @Data
    static class MetaResult {
        String icon;

        String title;
    }

}
