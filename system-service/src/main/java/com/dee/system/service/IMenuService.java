package com.dee.system.service;

import com.dee.basekit.mvc.result.Result;
import com.dee.system.param.MenuAddParam;
import com.dee.system.param.MenuEditParam;
import com.dee.system.param.MenuListPageParam;
import com.dee.system.result.MenuResult;

import java.util.List;

public interface IMenuService {
    Result save(MenuAddParam param);

    Result update(MenuEditParam param);

    Result delete(String id);

    Result<MenuResult> get(String id);

    Result<MenuResult> listPage(MenuListPageParam param);

    Result<List<MenuResult>> listTree(String tenantId);
}
