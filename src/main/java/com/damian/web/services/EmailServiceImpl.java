package com.damian.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public SimpleMailMessage template;

    @Override
    public void sendSimpleMessage(String from, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("oteromorales@gmail.com");
            message.setSubject(subject);
            message.setText("From: " + from + "  -  Text: " + text);
            message.setFrom("info@damianotero.es");


            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}
