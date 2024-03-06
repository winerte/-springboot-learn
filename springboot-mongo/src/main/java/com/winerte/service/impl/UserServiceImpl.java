package com.winerte.service.impl;

import com.winerte.eneity.User;
import com.winerte.service.IUserRepository;
import com.winerte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
