package com.nikamilon.mailsender;

import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
    private final EmailService emailService;

    public AuthController(EmailService emailService)
    {
        this.emailService = emailService;
    }

    @PostMapping("/send-code")
    public ResponseEntity<String> sendCode(@RequestParam("email") String email)
            throws MessagingException
    {
        emailService.sendConfirmationCode(email);
        return ResponseEntity.ok("Confirmation code sent.");
    }
}
