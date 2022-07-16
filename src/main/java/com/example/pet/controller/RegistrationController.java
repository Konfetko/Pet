package com.example.pet.controller;

import com.example.pet.entity.User;
import com.example.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @PostMapping
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return user;
    }
}
