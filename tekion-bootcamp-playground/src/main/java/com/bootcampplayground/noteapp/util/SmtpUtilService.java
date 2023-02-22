package com.bootcampplayground.noteapp.util;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmtpUtilService {

    private final JavaMailSender javaMailSender;

    public void sendEmail(String email, String data, String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("group4.verify@gmail.com");
        message.setTo(email);
        message.setText(data);
        message.setSubject(subject);
        javaMailSender.send(message);
        System.out.println("Mail sent successfully");
    }

}
