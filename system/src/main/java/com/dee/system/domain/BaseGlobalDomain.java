package com.dee.system.domain;

import com.dee.basekit.mvc.domain.BaseDomain;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseGlobalDomain extends BaseDomain {
    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;
}
