package com.dee.basekit.mvc.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ListPageParam {
    /**
     * 页码
     */
    private Integer pageNumber = 1;
    /**
     * 页条目数
     */
    private Integer pageSize = 10;

}
