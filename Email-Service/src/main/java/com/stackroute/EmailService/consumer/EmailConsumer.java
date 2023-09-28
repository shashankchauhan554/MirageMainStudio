package com.stackroute.EmailService.consumer;
import com.fasterxml.jackson.databind.ObjectMapper; // Use Jackson for JSON processing
import com.stackroute.EmailService.Service.EmailService;

import com.stackroute.EmailService.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmailConsumer {
    private final EmailService emailService;
    private final ObjectMapper objectMapper; // Jackson ObjectMapper for JSON processing
    @Autowired
    public EmailConsumer(EmailService emailService, ObjectMapper objectMapper) {
        this.emailService = emailService;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "user_email_queue")
    public void receiveMessage(String jsonUser) {
        try {
            // Deserialize JSON to User object
            User user = objectMapper.readValue(jsonUser,User.class);

            // Process and send email using user data
            emailService.sendConfirmationEmail(user);
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }
}
