package com.winerte.dao;

import com.winerte.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUser(int id);
}
