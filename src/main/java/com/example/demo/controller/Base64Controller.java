package com.example.demo.controller;

import com.example.demo.service.Base64Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Base64Controller {

    @Autowired
    private Base64Service base64Service;

    @PostMapping("/encode")
    public ResponseEntity<String> encodeString(@RequestBody String input) {
        if (input == null) {
            return ResponseEntity.badRequest().body("Invalid input: null");
        }
        String encodedString = base64Service.encodeToBase64(input);
        return ResponseEntity.ok(encodedString);
    }
}
