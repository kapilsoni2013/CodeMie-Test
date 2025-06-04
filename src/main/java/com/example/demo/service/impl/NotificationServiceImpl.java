package com.example.demo.service.impl;

import com.example.demo.dto.request.NotificationRequest;
import com.example.demo.dto.response.NotificationResponse;
import com.example.demo.entity.Notification;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationResponse createNotification(NotificationRequest request) {
        Notification notification = new Notification();
        notification.setMessage(request.getMessage());
        notification.setRead(false);
        notificationRepository.save(notification);
        return new NotificationResponse(notification);
    }
}