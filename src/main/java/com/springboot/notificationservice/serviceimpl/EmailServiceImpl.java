package com.springboot.notificationservice.serviceimpl;

import com.springboot.notificationservice.entity.EmailDetails;
import com.springboot.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendEmail(EmailDetails details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            if (details.getRecipient() == null
                || details.getMsgBody() == null
                || details.getSubject() == null) {
                throw new IllegalArgumentException("Invalid arguments provided");
            }

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Mock API calls
            javaMailSender.send(mailMessage);

            return "Email sent successfully";
        } catch (Exception ex) {
            return "Error: " + ex.toString();
        }
    }
}
