package com.dee.system.service;

import com.dee.system.global.BaseGlobalDomain;
import com.dee.system.param.EditUserParam;
import com.dee.system.param.ListUserParam;
import com.dee.system.param.UserResult;
import com.dee.system.param.SaveUserParam;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService<T extends BaseGlobalDomain> {
    UserResult findById(String id);

    UserResult save(SaveUserParam param);

    UserResult edit(EditUserParam param);

    boolean delete(String id);

    List<UserResult> findAll();

    Page<UserResult> page(ListUserParam param);
}
