package com.dee.system.service;

import com.dee.basekit.mvc.result.Result;
import com.dee.system.param.LoginParam;
import com.dee.system.result.LoginResult;

public interface IAccountService {
    Result<LoginResult> login(LoginParam loginParam);

    Result<String> logout();
}
