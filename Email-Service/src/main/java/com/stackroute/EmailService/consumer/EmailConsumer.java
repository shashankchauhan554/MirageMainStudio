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
    public void receiveMessage(String jsonMessage) {
        try {
            // Deserialize the JSON message into a Java object
           User registrationRequest = objectMapper.readValue(jsonMessage, User.class);

            // Process the registration request and send confirmation email
            emailService.sendConfirmationEmail(String.valueOf(registrationRequest));
        } catch (Exception e) {
            // Handle exceptions and logging
            e.printStackTrace();
        }
    }
}
