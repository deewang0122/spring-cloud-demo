package com.dee.system.service;

import com.dee.basekit.mvc.result.Result;
import com.dee.system.param.RoleAddParam;
import com.dee.system.param.RoleEditParam;
import com.dee.system.param.RoleListPageParam;
import com.dee.system.result.RoleResult;

public interface IRoleService {
    Result save(RoleAddParam param);

    Result update(RoleEditParam param);

    Result delete(String id);

    Result<RoleResult> get(String id);

    Result<RoleResult> listPage(RoleListPageParam param);
}
