package com.dee.system.result;

import com.dee.basekit.mvc.param.ListPageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class UserListPageResult {
    String name;
    String code;
    String email;
}
