package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {
    @Autowired
    private EmailService emailService;

    @Test
    public void testMails() {
        emailService.sendEmail("ce.karan25@gmail.com", "testing java mail sender", "Hey I am java mail sender object");
    }
}
