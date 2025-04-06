package com.nikamilon.mailsender;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ConfirmationCodeService
{
    public String generateCode()
    {
        Random random = new Random();
        return String.format("%06d", random.nextInt(999999));
    }
}
