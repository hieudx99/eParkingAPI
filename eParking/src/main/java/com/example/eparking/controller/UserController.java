package com.example.eparking.controller;

import com.example.eparking.model.User;
import com.example.eparking.model.dto.UserCredential;
import com.example.eparking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<User> checkLogin(@RequestBody UserCredential credential) {
        return userService.findByUsernameAndPassword
                (credential.getUsername(), credential.getPassword());
    }

    @GetMapping("/find-by-id")
    public Optional<User> getUserById(@RequestParam int id) {
        return userService.findById(id);
    }

    @GetMapping("/find-by-username")
    public Optional<User> getUserByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PutMapping("/update-info")
    public User updateInfo(@RequestBody User user) {
        return userService.updateInfo(user);
    }

    @GetMapping("/search-user")
    public List<User> searchUserByName(@RequestParam String kw) {
        return userService.searchUserByName(kw);
    }

    @PostMapping("/auth/google")
    public ResponseEntity<User> google(@RequestBody String googleAccessToken) {
        return userService.google(googleAccessToken);
    }

    @PostMapping("/auth/facebook")
    public ResponseEntity<User> facebook(@RequestBody String facebookAccessToken) {
        return userService.facebook(facebookAccessToken);
    }


}
