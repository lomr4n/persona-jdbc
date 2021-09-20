package com.example.personajdbc.Persona.infrastructure.repository.RowMapper;

import com.example.personajdbc.Persona.domain.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<Persona> {

    @Override
    public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Persona(resultSet.getInt("id"),
                resultSet.getString("password"),
                resultSet.getString("company_email"),
                resultSet.getString("personal_email"),
                resultSet.getString("city"),
                resultSet.getBoolean("active"),
                resultSet.getDate("created_date"),
                resultSet.getString("imagen_url"),
                resultSet.getDate("termination_date"));
    }
}
