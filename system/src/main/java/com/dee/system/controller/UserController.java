package com.dee.system.controller;

import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.param.Result;
import com.dee.system.domain.User;
import com.dee.system.exception.SystemException;
import com.dee.system.param.EditUserParam;
import com.dee.system.param.UserResult;
import com.dee.system.param.SaveUserParam;
import com.dee.system.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController  extends BaseController {

    @Autowired
    IUserService<User> userService;

    @PostMapping(value = "save")
    public Result<UserResult> save(@Valid @RequestBody SaveUserParam param) {
        return Result.success(userService.save(param));
    }

    @PostMapping(value = "edit")
    public Result<UserResult> edit(@Valid @RequestBody EditUserParam param) {
        return Result.success(userService.edit(param));
    }

    @PostMapping(value = "delete/{id}")
    public Result<Boolean> delete(@PathVariable(value = "id") String id) {
        return Result.success(userService.delete(id));
    }

    @GetMapping(value = "findById/{id}")
    public Result<UserResult> findById(@PathVariable(value = "id") String id) {
        return Result.success(userService.findById(id));
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
