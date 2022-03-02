package com.database.studentregistration.controller;


import com.database.studentregistration.requestresponse.RequestResponse;
import com.database.studentregistration.services.StudentService;
import com.database.studentregistration.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")


public class StudentController {

    @Autowired
    StudentService studentService;

    //gets all students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    //gets specific student by id
    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    //gets specific students by id and first name
    @GetMapping("/students/{id}/{firstName}")
    public Student getStudentByIdAndFirstName(@PathVariable("id") Long id, @PathVariable("firstName") String firstName){
       return studentService.findStudentByIdAndFirstName(id, firstName);
    }

    @PostMapping("/addStudent")
    public RequestResponse createStudent(@RequestBody Student student){
        Student s = studentService.addStudent(student);

        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setStatus(201);
        requestResponse.setMessage("Successfully added new student.");
        requestResponse.setStudent(s);

        return requestResponse;

        }


    }




