package com.dee.system.service.impl;

import com.dee.basekit.mvc.result.Result;
import com.dee.system.domain.MenuDomain;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.mapper.MenuMapper;
import com.dee.system.param.MenuAddParam;
import com.dee.system.param.MenuEditParam;
import com.dee.system.param.MenuListPageParam;
import com.dee.system.result.MenuResult;
import com.dee.system.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends BaseGlobalServiceImpl<MenuDomain, MenuMapper> implements IMenuService {

    @Override
    public Result save(MenuAddParam param) {
        return null;
    }

    @Override
    public Result update(MenuEditParam param) {
        return null;
    }

    @Override
    public Result delete(String id) {
        return null;
    }

    @Override
    public Result<MenuResult> get(String id) {
        return null;
    }

    @Override
    public Result<MenuResult> listPage(MenuListPageParam param) {
        return null;
    }

    @Override
    public Result<List<MenuResult>> listTree(String tenantId) {
        return null;
    }
}
