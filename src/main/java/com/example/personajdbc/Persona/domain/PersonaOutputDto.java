package com.example.personajdbc.Persona.domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaOutputDto {
    Integer id;
    String password;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;

    public PersonaOutputDto(Persona persona) {
        setId(persona.getId());
        setPassword(persona.getPassword());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_Date(persona.getCreated_Date());
        setImagen_url(persona.getImagen_url());
        setTermination_Date(persona.getTermination_Date());
    }
}