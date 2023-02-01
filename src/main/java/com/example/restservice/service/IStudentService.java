package com.example.restservice.service;

import com.example.restservice.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();

    Student getStudentByStudentNo(long stustudentNo);

    Student getStudentByFName(String fname);

    Student getStudentByLName(String lname);

    long createStudent(Student student);

    void updateStudent(long stustudentNo, Student student);

    void deleteStudent(long studentNo);
}
