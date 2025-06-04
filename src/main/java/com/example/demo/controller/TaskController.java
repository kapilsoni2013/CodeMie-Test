package com.example.demo.controller;

import com.example.demo.dto.request.TaskCreationRequest;
import com.example.demo.dto.response.TaskResponse;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskCreationRequest request) {
        return ResponseEntity.ok(taskService.createTask(request));
    }
}