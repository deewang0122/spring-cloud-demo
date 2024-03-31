package com.dee.system.controller;

import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.result.Result;
import com.dee.system.param.RoleListPageParam;
import com.dee.system.param.TenantAddParam;
import com.dee.system.param.TenantEditParam;
import com.dee.system.result.TenantResult;
import com.dee.system.service.ITenantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu")
public class TenantController extends BaseController {
    @Autowired
    ITenantService tenantService;

    @PostMapping(value = "save")
    public Result save(@Valid @RequestBody TenantAddParam param) {
        return tenantService.save(param);
    }

    @PostMapping(value = "edit")
    public Result edit(@Valid @RequestBody TenantEditParam param) {
        return tenantService.update(param);
    }

    @PostMapping(value = "delete/{id}")
    public Result delete(@PathVariable(value = "id") String id) {
        return tenantService.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public Result<TenantResult> get(@PathVariable(value = "id") String id) {
        return tenantService.get(id);
    }

    @GetMapping(value = "listPage")
    public Result<TenantResult> listPage(@Valid @RequestBody RoleListPageParam param) {
        return tenantService.listPage(param);
    }
}
