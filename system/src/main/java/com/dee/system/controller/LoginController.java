package com.dee.system.controller;

import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.param.Result;
import com.dee.system.domain.Account;
import com.dee.system.param.LoginParam;
import com.dee.system.param.LoginResult;
import com.dee.system.service.IAccountService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController extends BaseController {
    @Resource
    private IAccountService<Account> accountService;

    @PostMapping(value = "login")
    public Result<LoginResult> login(@RequestBody @Validated LoginParam loginParam) {
        return accountService.login(loginParam);
    }
}
