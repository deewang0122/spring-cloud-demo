package com.dee.system.param;

import com.dee.basekit.mvc.param.ListPageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MenuListPageParam extends ListPageParam {
    String name;
    String parentId;
}
