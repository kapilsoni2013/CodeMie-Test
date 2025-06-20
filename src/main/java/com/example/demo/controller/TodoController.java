package com.example.demo.controller;

import com.example.demo.dto.TodoDTO;
import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody TodoDTO todoDTO) {
        Todo createdTodo = todoService.createTodo(todoDTO);
        return ResponseEntity.ok(createdTodo);
    }
}

// Git operation is external to Java code implementation and should be handled using terminal or IDE integration. No changes were required in this file content.