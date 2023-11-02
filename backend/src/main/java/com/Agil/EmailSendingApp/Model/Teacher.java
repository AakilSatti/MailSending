package com.Agil.EmailSendingApp.Model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String email;
    private String name;
    private String subject;

}
