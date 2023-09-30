package com.dee.system.param;

import com.dee.basekit.mvc.param.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ListUserParam extends PageParam {
    String name;
    String code;
    String email;
}
