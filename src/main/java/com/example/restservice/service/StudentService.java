package com.example.restservice.service;

import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service//Now this class is a BEAN
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents(){
        return repository.getAllStudents();
    }
    public Student getStudentByStudentNo(long stustudentNo){
        return repository.getStudentByStudentNo(stustudentNo);
    }
    public Student getStudentByFName(String fname){
        return repository.getStudentByFName(fname);
    }
    public Student getStudentByLName(String lname){
        return repository.getStudentByLName(lname);
    }
    public long createStudent(Student student){
        return repository.createStudent(student);
    }
    public void updateStudent(long stustudentNo, Student student){
        repository.updateStudent(stustudentNo, student);
    }
    public void deleteStudent(long studentNo){
       repository.deleteStudent(studentNo);
    }
}
