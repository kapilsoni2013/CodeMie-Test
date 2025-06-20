package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

/**
 * DTO for Base64Request.
 * Handles the input string with validation.
 * Implements necessary changes for better conventions and practices.
 */
public class Base64Request {
    private static final String NULL_INPUT_ERROR_MESSAGE = "Input string cannot be null";

    @NotNull(message = NULL_INPUT_ERROR_MESSAGE)
    private String input;

    /**
     * Gets the input value.
     *
     * @return the input value
     */
    public String getInput() {
        return input;
    }

    /**
     * Sets the input value.
     *
     * @param input the input value to be set, must not be null
     */
    public void setInput(String input) {
        this.input = input;
    }
}