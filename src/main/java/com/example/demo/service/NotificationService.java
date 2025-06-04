package com.example.demo.service;

import com.example.demo.dto.request.NotificationRequest;
import com.example.demo.dto.response.NotificationResponse;

public interface NotificationService {
    NotificationResponse createNotification(NotificationRequest request);
}