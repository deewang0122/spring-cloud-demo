package com.dee.system.service.impl;

import com.dee.basekit.util.ObjectUtils;
import com.dee.system.domain.User;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.param.UserEditParam;
import com.dee.system.param.UserSaveParam;
import com.dee.system.repository.UserRepository;
import com.dee.system.service.IUserService;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseGlobalServiceImpl<User> implements IUserService<User> {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findById(String id) {
        val optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User save(UserSaveParam param) {
        User user = ObjectUtils.copyObject(param, instance());
        return userRepository.save(user);
    }

    @Override
    public User edit(UserEditParam param) {
        User user = ObjectUtils.copyObject(param, instance());
        return userRepository.save(user);
    }

    @Override
    public User delete(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        return null;
    }
}
