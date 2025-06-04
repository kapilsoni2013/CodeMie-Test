package com.example.demo.controller;

import com.example.demo.service.TaskService;
import com.example.demo.dto.request.TaskRequest;
import com.example.demo.dto.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest request) {
        return ResponseEntity.ok(taskService.createTask(request));
    }
}
