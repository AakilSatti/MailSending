package com.Agil.EmailSendingApp.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodDTO {
    private Integer Id;
    private String name;
    private String email;
}
