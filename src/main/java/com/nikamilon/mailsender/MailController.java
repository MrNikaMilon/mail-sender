package com.nikamilon.mailsender;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privet")
public class MailController
{
    private final MailService mailService;

    public MailController(MailService mailService)
    {
        this.mailService = mailService;
    }

    @PostMapping("/send-mail")
    public void sendMail(String code, String to)
    {
        mailService.sendConfirmationCode(code, to);
    }
}
