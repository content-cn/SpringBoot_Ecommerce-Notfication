package com.springboot.notificationservice.controller;

import com.springboot.notificationservice.entity.EmailDetails;
import com.springboot.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/email")
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    private String sendEmail(@RequestBody @Valid EmailDetails emailDetails) {
        String status = emailService.sendEmail(emailDetails);
        return status;
    }

}
