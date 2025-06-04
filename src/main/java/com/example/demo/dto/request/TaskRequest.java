package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;

public class TaskRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private boolean completed;

    // Getters and Setters
}
