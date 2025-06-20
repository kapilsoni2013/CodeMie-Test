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
    public static final String DECODE_ENDPOINT = "/decode";

    private final Base64Service base64Service;

    /**
     * Constructor for dependency injection.
     *
     * @param base64Service Service for handling Base64 encoding and decoding logic.
     */
    @Autowired
    public Base64Controller(Base64Service base64Service) {
        this.base64Service = base64Service;
    }

    /**
     * Endpoint to encode input string to Base64 format.
     *
     * @param request The input string wrapped in a Base64Request object.
     * @return Base64Response containing the encoded string.
     */
    @PostMapping(ENCODE_ENDPOINT)
    public ResponseEntity<Base64Response> encode(@Valid @RequestBody Base64Request request) {
        String encodedString = base64Service.encode(request.getInput());
        return ResponseEntity.ok(new Base64Response(encodedString));
    }

    /**
     * Endpoint to decode a Base64 string back to its original format.
     *
     * @param request The Base64 string wrapped in a Base64Request object.
     * @return Base64Response containing the decoded string.
     */
    @PostMapping(DECODE_ENDPOINT)
    public ResponseEntity<Base64Response> decode(@Valid @RequestBody Base64Request request) {
        String decodedString = base64Service.decode(request.getInput());
        return ResponseEntity.ok(new Base64Response(decodedString));
    }
}