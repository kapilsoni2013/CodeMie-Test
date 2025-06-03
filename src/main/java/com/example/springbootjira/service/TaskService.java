package com.example.springbootjira.service;

import com.example.springbootjira.model.Task;
import com.example.springbootjira.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
