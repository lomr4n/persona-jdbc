package com.example.personajdbc.Persona.domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaInputDto {
    String password;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;
}