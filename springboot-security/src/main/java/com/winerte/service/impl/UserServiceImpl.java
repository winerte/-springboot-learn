package com.winerte.service.impl;

import com.winerte.dao.UserMapper;
import com.winerte.pojo.User;
import com.winerte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public void login(String username, String password) {
        // 获取AuthenticationManager 进行用户认证
        // 1.将用户登录的用户名、密码 封装成一个authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(username ,password);

        // 2.authenticationManager来进行认证,
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // 判断认证结果
        // 1.如果认证不通过则抛出异常；
        if(Objects.isNull(authentication)){
            throw new RuntimeException("登录失败");
        }
        // 2.如果认证通过 利用userid生成应该jwt
        User loginUser = (User) authentication.getPrincipal();
        System.out.println(loginUser.toString());
        return ;

    }
}
