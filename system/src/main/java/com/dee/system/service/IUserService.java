package com.dee.system.service;

import com.dee.system.domain.User;
import com.dee.system.global.BaseGlobalDomain;
import com.dee.system.param.UserEditParam;
import com.dee.system.param.UserSaveParam;

public interface IUserService<T extends BaseGlobalDomain> {
    User findById(String id);

    User save(UserSaveParam param);

    User edit(UserEditParam param);

    User delete(String id);
}
