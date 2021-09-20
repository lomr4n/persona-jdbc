package com.example.personajdbc.Persona.domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona {
    Integer id;
    String password;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;

    public Persona(PersonaInputDto personaInputDto) {
        setPassword(personaInputDto.getPassword());
        setCompany_email(personaInputDto.getCompany_email());
        setPersonal_email(personaInputDto.getPersonal_email());
        setCity(personaInputDto.getCity());
        setActive(personaInputDto.getActive());
        setCreated_Date(personaInputDto.getCreated_Date());
        setImagen_url(personaInputDto.getImagen_url());
        setTermination_Date(personaInputDto.getTermination_Date());
    }
}