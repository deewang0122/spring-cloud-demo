package com.dee.system.service;

import com.dee.basekit.mvc.param.Result;
import com.dee.system.domain.Account;
import com.dee.system.param.LoginParam;
import com.dee.system.param.LoginResult;

public interface IAccountService {
    Account findByAccount(String account);

    Result<LoginResult> login(LoginParam loginParam);
}
