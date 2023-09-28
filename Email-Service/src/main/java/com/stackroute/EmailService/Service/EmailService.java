package com.stackroute.EmailService.Service;
import com.stackroute.EmailService.model.User;
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
    @Autowired

    private JavaMailSender emailSender ;
    @Autowired
    private ObjectMapper objectMapper ;


        @RabbitListener(queues = "user_queue")
        public void sendConfirmationEmail(String jsonUser) {
            try {
                // Deserialize JSON to a User object
                User user = objectMapper.readValue(jsonUser, User.class);

                // Extract relevant information from the User object
                String to = user.getTo();
                String subject = user.getSubject();
                String body = user.getBody();

                // Send confirmation email
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(to);
                message.setSubject(subject);
                message.setText(body);
                emailSender.send(message);
            } catch (Exception e) {
                // Handle exceptions and logging
            }
        }

}
