package com.winerte.service;

import com.winerte.eneity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IUserRepository extends MongoRepository<User, String> {

}
