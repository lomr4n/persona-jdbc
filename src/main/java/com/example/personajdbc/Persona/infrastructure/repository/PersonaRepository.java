package com.example.personajdbc.Persona.infrastructure.repository;

import com.example.personajdbc.Persona.domain.Persona;
import com.example.personajdbc.Persona.domain.PersonaOutputDto;
import com.example.personajdbc.Persona.infrastructure.repository.RowMapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PersonaOutputDto> getAll() {
        String consulta = "SELECT * FROM personas";
        PersonaMapper mapper = new PersonaMapper();
        return jdbcTemplate.query(consulta, (resultSet, i) -> {
            return new PersonaOutputDto(mapper.mapRow(resultSet, i));
        });
    }
    public PersonaOutputDto getOneById(Integer id) {
        String consulta = "SELECT * FROM personas WHERE id=?";
        Persona persona = jdbcTemplate.query(consulta, new PersonaMapper(), id).get(0);
        return new PersonaOutputDto(persona);
    }
    public void insert(Persona persona){
        String consulta = "INSERT INTO personas(password,company_email,personal_email,city,active,created_date,imagen_url,termination_date) VALUES(?,?,?,?,?,?,?,?) ";
        jdbcTemplate.update(consulta,
                persona.getPassword(), persona.getCompany_email(),
                persona.getPersonal_email(), persona.getCity(), persona.getActive(), persona.getCreated_Date(), persona.getImagen_url(),
                persona.getTermination_Date());
    }
    public void update(Persona persona, Integer id){
        String consulta="UPDATE personas SET password = ?,company_email = ?,personal_email = ?,city = ?,active = ?,created_date = ?,imagen_url = ?,termination_date = ? WHERE id = ?";
        jdbcTemplate.update(consulta,
                persona.getPassword(), persona.getCompany_email(),
                persona.getPersonal_email(), persona.getCity(), persona.getActive(), persona.getCreated_Date(), persona.getImagen_url(),
                persona.getTermination_Date(), id);
    }
    public void delete(Integer id){
        String query = "DELETE FROM personas WHERE id = ?";
        System.out.println(query);
        jdbcTemplate.update(query, id);

    }
}
