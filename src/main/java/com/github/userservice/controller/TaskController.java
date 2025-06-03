package com.github.userservice.controller;

import com.github.userservice.model.Task;
import com.github.userservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task created successfully!";
    }
}
