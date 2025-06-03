package com.github.userservice.service;

import com.github.userservice.model.User;
import com.github.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        // Save user to database
        userRepository.save(user);

        // Send confirmation email
        // EmailService.sendConfirmationEmail(user.getEmail());
    }

    public String loginUser(User user) {
        // Logic to authenticate user
        return "User logged in successfully!";
    }
}
