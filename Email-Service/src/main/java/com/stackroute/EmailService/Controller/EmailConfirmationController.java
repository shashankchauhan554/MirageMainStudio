package com.stackroute.EmailService.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.EmailService.Service.EmailService;
import com.stackroute.EmailService.model.User;
import javax.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

@RestController

public class EmailConfirmationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/api/email")
    public void sendConfirmationEmail(@RequestBody User confirmationEmail) throws MessagingException {
        emailService.sendConfirmationEmail(confirmationEmail);
    }
}