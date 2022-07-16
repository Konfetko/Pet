package com.example.pet.service;

import com.example.pet.entity.Todo;
import com.example.pet.repository.TodoRepository;
import com.example.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;
    public Todo createTodo(Todo todo,Long userID)
    {
        todo.setUser(userRepository.findById(userID).get());
        return todoRepository.save(todo);
    }
    public Todo checkTodo(Long id){
        var todo = todoRepository.findById(id).get();
        todo.setChecked(!todo.getChecked());
        return todo;
    }
}
