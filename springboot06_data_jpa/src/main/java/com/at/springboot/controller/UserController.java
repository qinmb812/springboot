package com.at.springboot.controller;

import com.at.springboot.entity.User;
import com.at.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        return userRepository.getById(id);
    }
}
