package com.dee.system.service;

import com.dee.basekit.mvc.result.Result;
import com.dee.system.domain.TenantDomain;
import com.dee.system.param.RoleListPageParam;
import com.dee.system.param.TenantAddParam;
import com.dee.system.param.TenantEditParam;
import com.dee.system.result.TenantResult;

public interface ITenantService {
    TenantDomain selectByUserId(String userId);
    Result save(TenantAddParam param);

    Result update(TenantEditParam param);

    Result delete(String id);

    Result<TenantResult> get(String id);

    Result<TenantResult> listPage(RoleListPageParam param);
}
