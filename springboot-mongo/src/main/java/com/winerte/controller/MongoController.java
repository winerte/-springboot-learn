package com.winerte.controller;

import com.winerte.eneity.User;
import com.winerte.service.IUserRepository;
import com.winerte.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MongoController {

    @Resource
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        User user = new User();
        user.setId("1");
        user.setName("winerte");
        userService.save(user);
        return "user saved";
    }
}
