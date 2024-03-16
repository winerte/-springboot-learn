package com.winerte.controller;

import com.winerte.pojo.User;
import com.winerte.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/get/{id}" )
    public User getUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        log.info("user:{}", user);
        return user;
    }
}
