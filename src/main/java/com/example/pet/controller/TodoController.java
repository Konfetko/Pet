package com.example.pet.controller;


import com.example.pet.entity.Todo;
import com.example.pet.entity.User;
import com.example.pet.service.TodoService;
import com.example.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class TodoController {
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
    @PostMapping("/removetodo")
    public ResponseEntity remove( @RequestParam Long todoId){
        return ResponseEntity.ok(todoService.removeTodo(todoId));
    }
    @GetMapping("/todo/{todoId}")
    public ResponseEntity checkTodo(@PathVariable("todoId") Long todoId){
        try{
            return ResponseEntity.ok(todoService.checkTodo(todoId));
        }catch (Exception ex)
        {
            return ResponseEntity.ok(null);
        }
    }
}
