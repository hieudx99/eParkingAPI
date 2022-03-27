package com.example.eparking.service;

import com.example.eparking.model.User;

import java.util.Optional;

public interface UserService {
    User findByUsernameAndPassword(String username, String password);
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
    User register(User user);
    User updateInfo(User user);

}
