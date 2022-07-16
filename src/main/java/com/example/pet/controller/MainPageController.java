package com.example.pet.controller;


import com.example.pet.entity.Todo;
import com.example.pet.entity.User;
import com.example.pet.repository.TodoRepository;
import com.example.pet.repository.UserRepository;
import com.example.pet.service.TodoService;
import com.example.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@CrossOrigin("*")
public class MainPageController {
    @Autowired
    private UserService userService;
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos/{userId}")
    public User userTodos(@PathVariable("userId") Long userId){
        return userService.findUserById(userId);
    }
    @PostMapping("/createtodo")
    public ResponseEntity add(@RequestBody Todo todo, @RequestParam Long userId){
        return ResponseEntity.ok(todoService.createTodo(todo,userId));
    }
    @GetMapping("/todo/{userId}&{todoId}")
    public boolean checkTodo(@PathVariable("userId") Long userId,@PathVariable("todoId") Long todoId){
        try{
            User user = userService
                    .findUserById(userId);
            Todo todo = user.getTodos()
                    .stream()
                    .filter(x->x.getIdTodo()==todoId)
                    .findFirst()
                    .get();
            todo.setChecked(!todo.getChecked());
            userService.saveUser(user);
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return true;
    }
}
