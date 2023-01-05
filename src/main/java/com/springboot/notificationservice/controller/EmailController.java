package com.springboot.notificationservice.controller;

import com.springboot.notificationservice.entity.EmailDetails;
import com.springboot.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    private String sendEmail(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendEmail(emailDetails);
        return status;
    }

}
