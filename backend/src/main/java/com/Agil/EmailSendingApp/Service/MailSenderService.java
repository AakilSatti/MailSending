package com.Agil.EmailSendingApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void EmailSendingService(String from,String to,String content){
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(to);
            mailMessage.setText(content);
            mailMessage.setSubject("Email Test");
            javaMailSender.send(mailMessage);
            System.out.println("Mail Sended Successfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
