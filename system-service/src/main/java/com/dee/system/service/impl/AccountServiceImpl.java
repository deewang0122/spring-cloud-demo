package com.dee.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dee.basekit.config.GlobalRedisManager;
import com.dee.basekit.config.LoginComponent;
import com.dee.basekit.mvc.login.UserToken;
import com.dee.basekit.mvc.result.Result;
import com.dee.basekit.util.BcryptUtils;
import com.dee.exception.SystemException;
import com.dee.system.domain.AccountDomain;
import com.dee.system.domain.TenantDomain;
import com.dee.system.domain.UserDomain;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.mapper.AccountMapper;
import com.dee.system.param.LoginParam;
import com.dee.system.result.LoginResult;
import com.dee.system.service.IAccountService;
import com.dee.system.service.IMenuService;
import com.dee.system.service.ITenantService;
import com.dee.system.service.IUserService;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Map;

import static com.dee.basekit.constant.Constants.EXPIRE_TIME;

// TODO...2023/9/11: 待优化
@Service
public class AccountServiceImpl extends BaseGlobalServiceImpl<AccountDomain, AccountMapper> implements IAccountService {
    @Resource
    private AccountMapper accountMapper;

    @Autowired
    IUserService userService;

    @Autowired
    ITenantService tenantService;

    @Autowired
    IMenuService menuService;


    @Override
    public Result<LoginResult> login(LoginParam loginParam) {
        LambdaQueryWrapper<AccountDomain> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AccountDomain::getAccount, loginParam.getUsername());
        AccountDomain account = accountMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(account)) {
            return Result.fail("Account does not exist");
        }

        UserDomain user = userService.selectById(account.getUserId());
        if (ObjectUtils.isEmpty(user)) {
            return Result.fail("User does not exist");
        }
        if (!loginParam.getPassword().equals(user.getPassword())) {
            return Result.fail("Password is error");
        }

        String tokenKey = getTokenKey(user);
        GlobalRedisManager.setAndExpire(tokenKey, getTokenValue(user), EXPIRE_TIME);

        LoginResult loginResult = new LoginResult();
        loginResult.setToken(tokenKey);
        return Result.success(loginResult);
    }

    private UserToken getTokenValue(UserDomain user) {
        UserToken userToken = new UserToken();
        userToken.setId(user.getId());
        userToken.setName(user.getName());
        userToken.setIsAdmin(user.getIsAdmin());

        TenantDomain tenant = tenantService.selectByUserId(user.getId());
        userToken.setTenantId(tenant.getId());
        userToken.setTenantName(tenant.getName());

        userToken.setExtProperties(Map.of("menuList", menuService.listTree(tenant.getId(), user.getId()).getData()));
        return userToken;
    }

    private String getTokenKey(UserDomain user) {
        return BcryptUtils.encode(user.getId() + user.getName());
    }

    @Override
    public Result<String> logout() {
        val delete = GlobalRedisManager.delete(LoginComponent.getToken());
        if (!delete) {
            throw new SystemException("退出登录异常");
        }
        return Result.success();
    }
}
