package com.stackroute.EmailService.Service;
import com.stackroute.EmailService.EmailServiceApplication;
import com.stackroute.EmailService.dto.EmailRequestDTO;
import com.stackroute.EmailService.model.User;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@EnableRabbit
@Service


public class EmailService {


    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    @RabbitListener(queues = "email_Queue")
    public void receiveMessage(EmailRequestDTO emailRequestDTO) {
        handleReceivedEmailForUser(emailRequestDTO);
    }


    public void sendConfirmationEmail(User User) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(User.getTo());
        message.setSubject(User.getSubject());
        message.setText(User.getBody());
        emailSender.send(message);

    }

    public void handleReceivedEmailForUser(EmailRequestDTO emailRequestDTO) {
        try {
            JSONObject jsonObject = emailRequestDTO.getJsonObject();
            String userEmail = (String) jsonObject.get("userEmail");
            String userName = (String) jsonObject.get("userName");
            if (userEmail != null && userName != null) {
                String subject = "Welcome to Miragemanestudios";
                String body = "Dear " + userName + ",\n\n"
                        + "Thank you for joining our platform. We are thrilled to have you as part of our community.\n\n"
                        + "At Miragemanestudio, "
                        + "Best regards,\n"
                        + "The Miragemanestudio Team";


                User emailMessage = new User(userEmail, subject, body);
                sendConfirmationEmail(emailMessage);
            } else {
                // Handle missing or null properties
                throw new IllegalArgumentException("Missing or null properties in EmailRequestDTO");
            }
        } catch (Exception e) {
            // Handle JSON parsing or other exceptions
            e.printStackTrace();
        }

    }
}








