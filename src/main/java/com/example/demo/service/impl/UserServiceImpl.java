package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(RegisterRequest request) {
        // Registration implementation
    }
    
    @Override
    public String confirmEmail(String token) {
        // Email confirmation implementation
    }

    @Override
    public UserResponse login(LoginRequest request) {
        // Login implementation
    }
}
