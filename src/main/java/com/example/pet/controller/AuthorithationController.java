package com.example.pet.controller;

import com.example.pet.entity.User;
import com.example.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthorithationController {
    @Autowired
    private UserService userService;
    @PostMapping("/userAuth")
    public ResponseEntity loginUser(@RequestBody User user){
        var us = userService.findUser(user);
        return ResponseEntity.ok(us);
    }
}
