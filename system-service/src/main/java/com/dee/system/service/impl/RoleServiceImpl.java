package com.dee.system.service.impl;

import com.dee.basekit.mvc.result.Result;
import com.dee.system.domain.RoleDomain;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.mapper.RoleMapper;
import com.dee.system.param.RoleAddParam;
import com.dee.system.param.RoleEditParam;
import com.dee.system.param.RoleListPageParam;
import com.dee.system.result.RoleResult;
import com.dee.system.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseGlobalServiceImpl<RoleDomain, RoleMapper> implements IRoleService {

    @Override
    public Result save(RoleAddParam param) {
        return null;
    }

    @Override
    public Result update(RoleEditParam param) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public Result<RoleResult> get(String id) {
        return null;
    }

    @Override
    public Result<RoleResult> listPage(RoleListPageParam param) {
        return null;
    }
}
