package com.nikamilon.mailsender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
    private final JavaMailSender mailSender;
    private final ConfirmationCodeService codeService;

    public EmailService(JavaMailSender mailSender, ConfirmationCodeService codeService)
    {
        this.mailSender = mailSender;
        this.codeService = codeService;
    }

    public void sendConfirmationCode(String email) throws MessagingException
    {
        String code = codeService.generateCode();
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(email);
        helper.setSubject("Email confirmation code");
        helper.setText("Confirmation code: " + code);
    }
}
