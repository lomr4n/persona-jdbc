package com.example.personajdbc.Persona.aplication;

import com.example.personajdbc.Persona.domain.Persona;
import com.example.personajdbc.Persona.domain.PersonaInputDto;
import com.example.personajdbc.Persona.domain.PersonaOutputDto;
import com.example.personajdbc.Persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IServicePersona{

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public List<PersonaOutputDto> findAll() throws Exception {
        try{
            List<PersonaOutputDto> entitiesDto = new ArrayList();
            entitiesDto = personaRepository.getAll();
            return entitiesDto;
        }catch(Exception e){
            throw new Exception("Error, no se encuentra ningun usuario");
        }
    }

    @Override
    public PersonaOutputDto findById(Integer id) throws Exception {
        PersonaOutputDto personaOutputDto = personaRepository.getOneById(id);
        return personaOutputDto;

    }

    @Override
    public PersonaOutputDto savePersona(PersonaInputDto personaInputDto) throws Exception {
        Persona persona = new Persona(personaInputDto);
        personaRepository.insert(persona);
        return new PersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto update(Integer id, PersonaInputDto personaInputDto) throws Exception {
        Persona persona = new Persona(personaInputDto);
        personaRepository.update(persona, id);
        return new PersonaOutputDto(persona);
    }

    @Override
    public boolean delete(Integer id) throws Exception {
            personaRepository.delete(id);
            return true;
    }
}
