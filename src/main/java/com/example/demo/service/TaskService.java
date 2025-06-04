package com.example.demo.service;

import com.example.demo.dto.request.TaskCreationRequest;
import com.example.demo.dto.response.TaskResponse;

public interface TaskService {
    TaskResponse createTask(TaskCreationRequest request);
}