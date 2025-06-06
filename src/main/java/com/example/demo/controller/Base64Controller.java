package com.example.demo.controller;

import com.example.demo.dto.Base64Request;
import com.example.demo.dto.Base64Response;
import com.example.demo.service.Base64Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/base64")
public class Base64Controller {

    @Autowired
    private Base64Service base64Service;

    @PostMapping("/encode")
    public ResponseEntity<Base64Response> encode(@Valid @RequestBody Base64Request request) {
        String encodedString = base64Service.encode(request.getInput());
        return ResponseEntity.ok(new Base64Response(encodedString));
    }
}