package com.Agil.EmailSendingApp.Model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "Period")
@Data
public class Period {

    @Id
    private Integer Id;
    private String name;
    @OneToOne
    private Teacher teacher;

}
