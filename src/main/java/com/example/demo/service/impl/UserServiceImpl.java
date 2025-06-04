package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRegistrationRequest;
import com.example.demo.dto.request.UserLoginRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(UserRegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setEnabled(false); // Email confirmation pending
        userRepository.save(user);
        // Send email confirmation logic here
        return new UserResponse(user);
    }

    @Override
    public UserResponse login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new UserResponse(user);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Override
    public void confirmEmail(String token) {
        // Email confirmation logic here
    }
}