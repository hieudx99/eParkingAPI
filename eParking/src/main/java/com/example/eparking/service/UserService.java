package com.example.eparking.service;

import com.example.eparking.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    ResponseEntity<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
    User register(User user);
    User updateInfo(User user);
    List<User> searchUserByName(String kw);
    ResponseEntity<User> google(String googleAccessToken);

}
