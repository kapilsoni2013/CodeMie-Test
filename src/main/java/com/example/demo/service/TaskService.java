package com.example.demo.service;

import com.example.demo.dto.request.TaskRequest;
import com.example.demo.dto.response.TaskResponse;

public interface TaskService {
    TaskResponse createTask(TaskRequest request);
}
