package com.stackroute.EmailService.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.stackroute.EmailService.Service.EmailService;
import com.stackroute.EmailService.model.User;
import javax.mail.MessagingException;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/email")
public class EmailConfirmationController {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    private EmailService emailService;
    private ObjectMapper objectMapper ;

    @PostMapping("/confirm")
    public void sendConfirmationEmail(@RequestBody User user)  {
        try {
            // Serialize UserRegistrationRequest to JSON
            String jsonUser = objectMapper.writeValueAsString(user);

            // Send the JSON object to the RabbitMQ queue
            rabbitTemplate.convertAndSend("Saloon_exchange", "thisisemailkey", jsonUser);
        } catch (Exception e) {
            // Handle exceptions and logging
        }
    }

}