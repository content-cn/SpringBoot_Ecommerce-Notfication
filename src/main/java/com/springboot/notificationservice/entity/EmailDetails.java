package com.springboot.notificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

    @NotBlank(message = "Recipient cannot be empty")
    private String recipient;

    @NotBlank(message = "Message body cannot be empty")
    private String msgBody;

    @NotBlank(message = "Subject cannot be empty")
    private String subject;
    private String attachment;

}
