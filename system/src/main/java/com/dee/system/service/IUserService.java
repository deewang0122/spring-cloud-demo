package com.dee.system.service;

import com.dee.system.domain.BaseGlobalDomain;
import com.dee.system.domain.User;

public interface IUserService<T extends BaseGlobalDomain> {
    User findById(String id);
}
