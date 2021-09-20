package com.example.personajdbc.Persona.aplication;

import com.example.personajdbc.Persona.domain.PersonaInputDto;
import com.example.personajdbc.Persona.domain.PersonaOutputDto;

import java.util.List;

public interface IServicePersona {
    public List<PersonaOutputDto> findAll() throws Exception;
    public PersonaOutputDto findById(Integer id) throws Exception;
    public PersonaOutputDto savePersona(PersonaInputDto persona) throws Exception;
    public PersonaOutputDto update(Integer id, PersonaInputDto persona) throws Exception;
    public boolean delete(Integer id) throws Exception;
}
