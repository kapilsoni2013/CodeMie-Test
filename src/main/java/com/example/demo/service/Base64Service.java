package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public class Base64Service {

    public String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}