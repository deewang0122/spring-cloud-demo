package com.dee.system.service;

import com.dee.system.global.BaseGlobalDomain;
import com.dee.system.param.UserEditParam;
import com.dee.system.param.UserResult;
import com.dee.system.param.UserSaveParam;

import java.util.List;

public interface IUserService<T extends BaseGlobalDomain> {
    UserResult findById(String id);

    UserResult save(UserSaveParam param);

    UserResult edit(UserEditParam param);

    boolean delete(String id);

    List<UserResult> findAll();


}
