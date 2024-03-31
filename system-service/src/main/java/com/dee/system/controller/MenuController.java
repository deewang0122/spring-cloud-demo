package com.dee.system.controller;

import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.result.Result;
import com.dee.system.param.MenuAddParam;
import com.dee.system.param.MenuEditParam;
import com.dee.system.param.MenuListPageParam;
import com.dee.system.result.MenuResult;
import com.dee.system.service.IMenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {
    @Autowired
    IMenuService menuService;

    @PostMapping(value = "save")
    public Result save(@Valid @RequestBody MenuAddParam param) {
        return menuService.save(param);
    }

    @PostMapping(value = "edit")
    public Result edit(@Valid @RequestBody MenuEditParam param) {
        return menuService.update(param);
    }

    @PostMapping(value = "delete/{id}")
    public Result delete(@PathVariable(value = "id") String id) {
        return menuService.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public Result<MenuResult> get(@PathVariable(value = "id") String id) {
        return menuService.get(id);
    }

    @GetMapping(value = "listPage")
    public Result<MenuResult> listPage(@Valid @RequestBody MenuListPageParam param) {
        return menuService.listPage(param);
    }
}
