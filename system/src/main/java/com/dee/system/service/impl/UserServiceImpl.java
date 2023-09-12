package com.dee.system.service.impl;

import com.dee.system.domain.User;
import com.dee.system.global.BaseGlobalServiceImpl;
import com.dee.system.repository.UserRepository;
import com.dee.system.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseGlobalServiceImpl<User> implements IUserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }
}
