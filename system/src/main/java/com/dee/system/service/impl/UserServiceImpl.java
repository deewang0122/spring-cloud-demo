package com.dee.system.service.impl;

import com.dee.basekit.util.ObjectUtils;
import com.dee.system.domain.User;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.param.EditUserParam;
import com.dee.system.param.ListUserParam;
import com.dee.system.param.SaveUserParam;
import com.dee.system.param.UserResult;
import com.dee.system.repository.UserRepository;
import com.dee.system.service.IUserService;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseGlobalServiceImpl<User> implements IUserService<User> {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserResult findById(String id) {
        val optionalUser = userRepository.findById(id);
        return ObjectUtils.copyObject(optionalUser.orElse(null), new UserResult());
    }

    @Override
    public UserResult save(SaveUserParam param) {
        User user = ObjectUtils.copyObject(param, instance());
        return ObjectUtils.copyObject(userRepository.save(user), new UserResult());
    }

    @Override
    public UserResult edit(EditUserParam param) {
        User user = ObjectUtils.copyObject(param, instance());
        return ObjectUtils.copyObject(userRepository.save(user), new UserResult());
    }

    @Override
    public boolean delete(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }

        return true;
    }

    @Override
    public List<UserResult> findAll() {
        return ObjectUtils.copyObject(userRepository.findAll(), UserResult.class);
    }

    @Override
    public Page<UserResult> page(ListUserParam param) {
        return null;
    }
}
