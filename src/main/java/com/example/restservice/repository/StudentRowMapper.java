package com.example.restservice.repository;

import com.example.restservice.model.Student;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
         return Student.builder().studentNo(rs.getLong("studentNo"))
                 .fName(rs.getString("fName"))
                .lName(rs.getString("lName"))
                .address(rs.getString("address"))
                .activeflag(rs.getBoolean("activeflag")).build();
    }
}
