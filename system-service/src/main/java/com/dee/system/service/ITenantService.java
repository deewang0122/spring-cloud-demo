package com.dee.system.service;

import com.dee.basekit.mvc.result.Result;
import com.dee.system.domain.TenantDomain;
import com.dee.system.param.TenantAddParam;
import com.dee.system.param.TenantEditParam;
import com.dee.system.param.TenantListParam;
import com.dee.system.result.TenantResult;

import java.util.List;

public interface ITenantService {
    TenantDomain selectByUserId(String userId);
    Result save(TenantAddParam param);

    Result update(TenantEditParam param);

    Result delete(String id);

    Result<TenantResult> get(String id);

    Result<List<TenantResult>> list(TenantListParam param);
}
