package com.nikamilon.mailsender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService
{
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender)
    {
        this.mailSender = mailSender;
    }

    public void sendConfirmationCode(String code, String to)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("SCH Confirmation Code");
        message.setText("Your confirmation code is: " + code);
        mailSender.send(message);
    }
}
