package com.dee.system.param;

import com.dee.basekit.mvc.param.ListPageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserListPageParam extends ListPageParam {
    String name;
    String code;
    String email;
}
