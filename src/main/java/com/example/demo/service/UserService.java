package com.example.demo.service;

import com.example.demo.dto.request.UserRegistrationRequest;
import com.example.demo.dto.request.UserLoginRequest;
import com.example.demo.dto.response.UserResponse;

public interface UserService {
    UserResponse register(UserRegistrationRequest request);
    UserResponse login(UserLoginRequest request);
    void confirmEmail(String token);
}