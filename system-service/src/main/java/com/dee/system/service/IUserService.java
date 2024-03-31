package com.dee.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dee.basekit.mvc.result.Result;
import com.dee.system.domain.UserDomain;
import com.dee.system.param.UserEditParam;
import com.dee.system.param.UserListPageParam;
import com.dee.system.param.UserSaveParam;
import com.dee.system.result.UserListPageResult;
import com.dee.system.result.UserResult;

public interface IUserService {
    UserDomain selectById(String id);

    Result<UserResult> get(String id);

    Result save(UserSaveParam param);

    Result update(UserEditParam param);

    Result delete(String id);

    Result<IPage<UserListPageResult>> listPage(UserListPageParam param);
}
