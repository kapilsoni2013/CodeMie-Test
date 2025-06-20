package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class Base64Request {
    private static final String NULL_INPUT_ERROR_MESSAGE = "Input string cannot be null";

    @NotNull(message = NULL_INPUT_ERROR_MESSAGE)
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}