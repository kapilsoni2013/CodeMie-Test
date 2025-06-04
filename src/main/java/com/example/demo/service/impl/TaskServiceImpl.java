package com.example.demo.service.impl;

import com.example.demo.service.TaskService;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.dto.request.TaskRequest;
import com.example.demo.dto.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(TaskRequest request) {
        // Task creation implementation
    }
}
