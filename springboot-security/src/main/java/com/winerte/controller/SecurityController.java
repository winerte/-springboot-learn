package com.winerte.controller;

import com.winerte.pojo.User;
import com.winerte.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SecurityController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        log.info("login{}", user);
        userService.login(user.getUsername(), user.getPassword());
        return "success";
    }
}
