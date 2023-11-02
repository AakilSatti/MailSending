package com.Agil.EmailSendingApp.Service;


//import com.Agil.EmailSendingApp.Repository.EmailSendingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class MailService {

    private final String senderMail = "kit.24.20bcs006@gmail.com";

    @Autowired
    private MailSenderService mailSenderService;

//   public ResponseEntity<?> sendMail(EmailSending emailSending){
//
//        mailSenderService.EmailSendingService(senderMail,emailSending.getEmail(),"hello");
//        return new ResponseEntity<>("Mail Sent", HttpStatus.OK);
//   }


}
