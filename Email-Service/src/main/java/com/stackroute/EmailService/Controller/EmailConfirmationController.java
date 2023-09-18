package com.stackroute.EmailService.Controller;
import com.stackroute.EmailService.Repository.UserRepository;
import com.stackroute.EmailService.Service.EmailService;
import com.stackroute.EmailService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@RestController
@RequestMapping("/email")
public class EmailConfirmationController {
    private final EmailService emailService;
    private final UserRepository userRepository;

    @Autowired
    public EmailConfirmationController(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }
    @PostMapping("/send-confirmation")
    public String sendConfirmationEmail(@RequestParam String email) {
        // Check if the user already exists in the database
        User user = userRepository.findById(email).orElse(null);

        if (user == null) {
            // User does not exist, create a new user
            user = new User(email, false);
        }

        // Generate a unique confirmation token
        String confirmationToken = generateConfirmationToken();

        // Send the confirmation email
        String confirmationLink = "http://your-app.com/confirm?token=" + confirmationToken;
        emailService.sendConfirmationEmail(email, confirmationLink);

        // Update the user's confirmation status and save to the database
        user.setConfirmed(false); // Set to false to indicate unconfirmed email
        userRepository.save(user);

        // Return a response, indicating that the email has been sent
        return "Email sent for confirmation.";
    }
    private String generateConfirmationToken() {
        return UUID.randomUUID().toString();
    }
    @GetMapping("/confirm")
    public String confirmEmail(@RequestParam String token) {
        // Find the user with the corresponding email
        User user = userRepository.findByToken(token);

        if (user != null) {
            // Token matches, update the user's email status
            user.setConfirmed(true);
            userRepository.save(user);

            // Return a success message
            return "Email confirmed successfully for user: " + user.getEmail();
        } else {
            // If the token is not found or invalid, return an error message
            return "Invalid confirmation token.";
        }
    }
}
