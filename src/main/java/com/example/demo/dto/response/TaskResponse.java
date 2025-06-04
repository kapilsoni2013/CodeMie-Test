package com.example.demo.dto.response;

import com.example.demo.entity.Task;

public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.completed = task.isCompleted();
    }

    // Getters and Setters
}
