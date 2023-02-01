package com.example.restservice.controller;

import com.example.restservice.model.Student;
import com.example.restservice.service.IStudentService;
import com.example.restservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//This is a REST API
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    //GET all the students
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    //Get the student by studentNo
    @GetMapping("/find/{stustudentNo}")
    public ResponseEntity<Student> getStudentByStudentNo(@PathVariable long stustudentNo){
        return new ResponseEntity<>(studentService.getStudentByStudentNo(stustudentNo), HttpStatus.OK);
    }
    //Get the student by fName
    @GetMapping("/find")
    public ResponseEntity<Student> getStudentByFName(@RequestParam String fname){
        return new ResponseEntity<>(studentService.getStudentByFName(fname), HttpStatus.OK);
    }

    //Get the student by lName
    @GetMapping("/check")
    public ResponseEntity<Student> getStudentByLName(@RequestParam String lname){
        return new ResponseEntity<>(studentService.getStudentByLName(lname), HttpStatus.OK);
    }

    //Create a student
    @PostMapping("/")
    public ResponseEntity<Long> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    //Update a student
    @PutMapping("/studentNo/{stustudentNo}")
    public ResponseEntity<Void> updateStudent(@PathVariable long stustudentNo, @RequestBody Student student){
        studentService.updateStudent(stustudentNo, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Delete a student
    @DeleteMapping("/studentNo/{studentNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long studentNo){
        studentService.deleteStudent(studentNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

