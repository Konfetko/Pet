package com.example.pet.controller;

import com.example.pet.entity.User;
import com.example.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthorithationController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/userAuth")
    public ResponseEntity loginUser(@RequestBody User user){
        var us = userService.findUser(user);
        if(us!=null)
            return ResponseEntity.ok(us);
        else
            return ResponseEntity.badRequest().body("Пользователь не найден");
    }
}
