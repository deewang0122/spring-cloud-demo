package com.dee.system.controller;

import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.result.Result;
import com.dee.exception.SystemException;
import com.dee.system.param.UserEditParam;
import com.dee.system.param.UserSaveParam;
import com.dee.system.result.UserResult;
import com.dee.system.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController  extends BaseController {

    @Autowired
    IUserService userService;

    @PostMapping(value = "save")
    public Result save(@Valid @RequestBody UserSaveParam param) {
        return userService.save(param);
    }

    @PostMapping(value = "edit")
    public Result edit(@Valid @RequestBody UserEditParam param) {
        return userService.update(param);
    }

    @PostMapping(value = "delete/{id}")
    public Result delete(@PathVariable(value = "id") String id) {
        return userService.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public Result<UserResult> get(@PathVariable(value = "id") String id) {
        return userService.get(id);
    }

    @GetMapping(value = "findAll")
    public Result<List<UserResult>> findAll() {
        throw new SystemException("this ia a test error");
        //return Result.success(userService.findAll());
    }

    @GetMapping(value = "findAll2")
    public Result<List<UserResult>> findAll2() {
        int i = 4/0;
        return Result.success();
    }

}
