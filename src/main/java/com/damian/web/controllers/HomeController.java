package com.damian.web.controllers;

import com.damian.web.services.EmailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailServiceImpl emailService;


    @GetMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String sendEmail(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam String subject,
                            @RequestParam String message){
        log.info("Email controller called!");
        log.info(name);
        log.info(email);
        log.info(subject);
        log.info(message);

        emailService.sendSimpleMessage(name +"- Email:  "+ email, subject,message);
        log.info("Email controller called!");

        return "fragments/sent-message";
    }
}
