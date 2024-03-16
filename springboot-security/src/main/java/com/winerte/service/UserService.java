package com.winerte.service;

import com.winerte.pojo.User;

public interface UserService {
    User getUser(int id);

    void login(String username, String password);
}
