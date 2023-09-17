package com.dee.system.controller;

import com.dee.basekit.mvc.controller.BaseController;
import com.dee.basekit.mvc.param.Result;
import com.dee.basekit.util.ObjectUtils;
import com.dee.system.domain.User;
import com.dee.system.param.UserResult;
import com.dee.system.param.UserSaveParam;
import com.dee.system.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController  extends BaseController {

    @Autowired
    IUserService<User> userService;

    @PostMapping(value = "save")
    public Result<UserResult> save(@Valid @RequestBody UserSaveParam param) {
        return Result.success(ObjectUtils.copyObject(userService.save(param), new UserResult()));
    }

}
