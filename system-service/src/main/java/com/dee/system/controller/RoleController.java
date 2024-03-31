package com.dee.system.controller;

import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.result.Result;
import com.dee.system.param.RoleAddParam;
import com.dee.system.param.RoleEditParam;
import com.dee.system.param.RoleListPageParam;
import com.dee.system.result.RoleResult;
import com.dee.system.service.IRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleController extends BaseController {
    @Autowired
    IRoleService roleService;

    @PostMapping(value = "save")
    public Result save(@Valid @RequestBody RoleAddParam param) {
        return roleService.save(param);
    }

    @PostMapping(value = "edit")
    public Result edit(@Valid @RequestBody RoleEditParam param) {
        return roleService.update(param);
    }

    @PostMapping(value = "delete/{id}")
    public Result delete(@PathVariable(value = "id") String id) {
        return roleService.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public Result<RoleResult> get(@PathVariable(value = "id") String id) {
        return roleService.get(id);
    }

    @GetMapping(value = "listPage")
    public Result<RoleResult> listPage(@Valid @RequestBody RoleListPageParam param) {
        return roleService.listPage(param);
    }
}
