package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class Base64Request {
    @NotNull(message = "Input string cannot be null")
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}