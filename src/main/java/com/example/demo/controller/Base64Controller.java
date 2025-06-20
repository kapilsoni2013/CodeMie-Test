package com.example.demo.controller;

import com.example.demo.dto.Base64Request;
import com.example.demo.dto.Base64Response;
import com.example.demo.service.Base64Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping(Base64Controller.BASE64_API_URL)
public class Base64Controller {

    public static final String BASE64_API_URL = "/api/v1/base64";
    public static final String ENCODE_ENDPOINT = "/encode";

    @Autowired
    private Base64Service base64Service;

    @PostMapping(ENCODE_ENDPOINT)
    public ResponseEntity<Base64Response> encode(@Valid @RequestBody Base64Request request) {
        String encodedString = base64Service.encode(request.getInput());
        return ResponseEntity.ok(new Base64Response(encodedString));
    }
}