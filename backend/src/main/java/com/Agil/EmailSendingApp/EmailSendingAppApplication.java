package com.Agil.EmailSendingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class EmailSendingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSendingAppApplication.class, args);
	}

}
