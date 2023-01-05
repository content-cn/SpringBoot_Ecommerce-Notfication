package com.springboot.notificationservice.service;

import com.springboot.notificationservice.entity.EmailDetails;

public interface EmailService {

    String sendEmail(EmailDetails details);

}
