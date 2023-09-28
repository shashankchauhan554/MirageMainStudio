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


    private  final JavaMailSender emailSender ;
    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

        @RabbitListener(queues = "user_email_queue")
        public void sendConfirmationEmail(User user) {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(user.getTo());
            message.setSubject(user.getSubject());
            message.setText(user.getBody());
            try {
                emailSender.send(message);
                System.out.println("Email sent successfully.");
            } catch (Exception e) {
                // Handle exceptions and logging
                System.err.println("Error sending email: " + e.getMessage());
            }
        }





}
