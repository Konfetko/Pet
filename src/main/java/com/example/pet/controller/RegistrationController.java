package com.example.pet.controller;

import com.example.pet.entity.User;
import com.example.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @PostMapping("/registration")
    public ResponseEntity createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
}
