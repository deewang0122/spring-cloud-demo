package com.dee.system.service.impl;

import com.dee.basekit.config.GlobalRedisManager;
import com.dee.basekit.mvc.domain.UserToken;
import com.dee.basekit.mvc.param.Result;
import com.dee.basekit.util.BcryptUtils;
import com.dee.system.domain.Account;
import com.dee.system.domain.User;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.param.LoginParam;
import com.dee.system.param.LoginResult;
import com.dee.system.repository.AccountRepository;
import com.dee.system.service.IAccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import static com.dee.basekit.constant.Constants.EXPIRE_TIME;

// TODO...2023/9/11: 待优化
@Service
public class AccountServiceImpl extends BaseGlobalServiceImpl<Account> implements IAccountService<Account> {
    @Resource
    private AccountRepository accountRepository;


    @Override
    public Result<LoginResult> login(LoginParam loginParam) {
        Account account = accountRepository.findByAccount(loginParam.getAccount());
        if (ObjectUtils.isEmpty(account)) {
            return Result.fail("Account does not exist");
        }
        if (ObjectUtils.isEmpty(account.getUser())) {
            return Result.fail("User does not exist");
        }
        if (!loginParam.getPassword().equals(account.getUser().getPassword())) {
            return Result.fail("password is error");
        }
        String token = doToken(account.getUser());
        GlobalRedisManager.setAndExpire(token, doUserToken(account.getUser()), EXPIRE_TIME);

        LoginResult loginResult = new LoginResult();
        loginResult.setToken(token);
        return Result.success(loginResult);
    }

    private UserToken doUserToken(User user) {
        UserToken userToken = new UserToken();
        userToken.setId(user.getId());
        userToken.setName(user.getName());
        return userToken;
    }

    private String doToken(User user) {
        return BcryptUtils.encode(user.getId() + user.getName());
    }

    @Override
    public Account findByAccount(String account) {
        return accountRepository.findByAccount(account);
    }
}
