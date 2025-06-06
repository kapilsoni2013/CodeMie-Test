package com.example.demo.dto;

public class Base64Response {
    private String encoded;

    public Base64Response(String encoded) {
        this.encoded = encoded;
    }

    public String getEncoded() {
        return encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }
}