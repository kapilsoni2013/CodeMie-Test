package com.github.userservice.service;

import com.github.userservice.model.Task;
import com.github.userservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(Task task) {
        // Save task to database
        taskRepository.save(task);
    }
}
