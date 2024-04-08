package com.dee.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dee.basekit.config.LoginComponent;
import com.dee.basekit.mvc.result.Result;
import com.dee.basekit.util.ObjectUtils;
import com.dee.system.domain.UserDomain;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.mapper.UserMapper;
import com.dee.system.param.TenantListParam;
import com.dee.system.param.UserEditParam;
import com.dee.system.param.UserListPageParam;
import com.dee.system.result.MenuListTreeResult;
import com.dee.system.result.TenantResult;
import com.dee.system.result.UserResult;
import com.dee.system.param.UserSaveParam;
import com.dee.system.result.UserListPageResult;
import com.dee.system.service.IMenuService;
import com.dee.system.service.ITenantService;
import com.dee.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseGlobalServiceImpl<UserDomain, UserMapper> implements IUserService {

    @Autowired
    IMenuService menuService;

    @Autowired
    ITenantService tenantService;

    @Override
    public UserDomain selectById(String id) {
        return getBaseMapper().selectById(id);
    }

    @Override
    public Result<UserResult> get(String id) {
        return Result.success(ObjectUtils.copyObject(getBaseMapper().selectById(id), new UserResult()));
    }

    @Override
    public Result save(UserSaveParam param) {
        UserDomain entity = ObjectUtils.copyObject(param, createDomain());
        getBaseMapper().insert(entity);
        return Result.success();
    }

    @Override
    public Result update(UserEditParam param) {
        UserDomain entity = ObjectUtils.copyObject(param, createDomain());
        getBaseMapper().updateById(entity);
        return Result.success();
    }

    @Override
    public Result delete(String id) {
        getBaseMapper().deleteById(id);
        return Result.success();
    }

    @Override
    public Result<IPage<UserListPageResult>> listPage(UserListPageParam param) {

        return null;
    }


}
