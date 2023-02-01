package com.example.restservice.repository;

import com.example.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // to make BEAN as a repository for connecting to mysql
public class StudentRepository {
    //Methods to do the database operations
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudents(){
        //connect to database for fetching real data
//        return jdbcTemplate.query("SELECT studentNo, fName, lName, address, active FROM student",
//                (rs, rowNum) -> new Student(rs.getLong("studentNo"),
//                                            rs.getString("fName"),
//                        rs.getString("lName"),
//                        rs.getString("address"),
//                        rs.getBoolean("active")
//                        )
//        );
        return jdbcTemplate.query("SELECT studentNo, fName, lName, address, activeflag FROM student", new StudentRowMapper());
    }
    public Student getStudentByStudentNo(long stustudentNo){
        String sql = "SELECT * FROM student WHERE studentNo=?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), stustudentNo);
    }

    public Student getStudentByFName(String fname){
        String sql = "SELECT * FROM student WHERE fname=?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), fname);
    }


    public Student getStudentByLName(String lname){
        String sql = "SELECT * FROM student WHERE lname=?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), lname);
    }

    public long createStudent(Student student){
        String sql = "INSERT INTO student(fName, lName, address, activeflag) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, student.getFName(), student.getLName(), student.getAddress(), student.isActiveflag());
        //return the studentNo of new student
        return jdbcTemplate.queryForObject("SELECT MAX(studentNo) from student", Long.class);
    }

    public void updateStudent(long studentNo, Student student){
        String sql = "UPDATE student set fName=?, lName=?, address=?, activeflag=? WHERE studentNo=?";
        jdbcTemplate.update(sql, student.getFName(), student.getLName(), student.getAddress(), student.isActiveflag(), studentNo);
    }

    public void deleteStudent(long studentNo){
        String sql = "DELETE FROM student WHERE studentNo=?";
        jdbcTemplate.update(sql, studentNo);
    }
}
