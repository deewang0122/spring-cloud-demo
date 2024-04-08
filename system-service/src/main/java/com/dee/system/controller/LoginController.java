package com.dee.system.controller;

import com.dee.basekit.config.LoginComponent;
import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.result.Result;
import com.dee.system.param.LoginParam;
import com.dee.system.param.TenantListParam;
import com.dee.system.result.LoginResult;
import com.dee.system.result.MenuListTreeResult;
import com.dee.system.result.TenantResult;
import com.dee.system.service.IAccountService;
import com.dee.system.service.IMenuService;
import com.dee.system.service.ITenantService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LoginController extends BaseController {
    @Resource
    private IAccountService accountService;

    @Resource
    private IMenuService menuService;

    @Resource
    private ITenantService tenantService;


    @PostMapping(value = "login")
    public Result<LoginResult> login(@RequestBody @Validated LoginParam loginParam) {
        return accountService.login(loginParam);
    }

    @PostMapping(value = "logout")
    public Result<String> logout() {
        return accountService.logout();
    }

    @PostMapping(value = "listMenu")
    public Result<List<MenuListTreeResult>> listMenu(@RequestParam(name = "tenantId")
                                                         @NotEmpty(message = "租户Id不能为空") String tenantId) {
        return menuService.listTree(tenantId, LoginComponent.getUserId());
    }

    @PostMapping(value = "listTenant")
    public Result<List<TenantResult>> listTenant() {
        TenantListParam param = new TenantListParam();
        param.setUserId(LoginComponent.getUserId());
        return tenantService.list(param);
    }
}
