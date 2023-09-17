package com.stackroute.EmailService.Controller;
import com.stackroute.EmailService.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/email")
public class EmailConfirmationController {
    private final EmailService emailService;
    private final Map<String, String> userConfirmationMap = new HashMap<>(); // Store user-to-token mapping

    @Autowired
    public EmailConfirmationController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/send-confirmation")
    public String sendConfirmationEmail(@RequestParam String email) {

        String confirmationToken = generateConfirmationToken();


        String confirmationLink = "http://your-app.com/confirm?token=" + confirmationToken;
        emailService.sendConfirmationEmail(email, confirmationLink);


        userConfirmationMap.put(email, confirmationToken);


        return "Email sent for confirmation.";

    }
    private String generateConfirmationToken() {
        // Implement your logic to generate a random token
        // You can use UUID.randomUUID().toString() for a simple token
        return UUID.randomUUID().toString();
    }


}
