package com.stackroute.EmailService.Service;
import com.stackroute.EmailService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendConfirmationEmail(User confirmationEmail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(confirmationEmail.getTo());
        helper.setSubject(confirmationEmail.getSubject());
        helper.setText(confirmationEmail.getBody(), true);

        javaMailSender.send(mimeMessage);
    }
}
