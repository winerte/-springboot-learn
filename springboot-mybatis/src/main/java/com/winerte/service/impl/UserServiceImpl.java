package com.winerte.service.impl;

import com.winerte.dao.UserMapper;
import com.winerte.pojo.User;
import com.winerte.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }
}
