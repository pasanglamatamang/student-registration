package com.database.studentregistration.controller;


import com.database.studentregistration.requestresponse.RequestResponse;
import com.database.studentregistration.services.StudentService;
import com.database.studentregistration.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")


public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/showAllStudents")
    public List<Student> getAllStudents(){

        return studentService.findAll();

    }

    @PostMapping("/addStudent")
    public Student createStudent(@RequestBody Student student){
        /*RequestResponse requestResponse = new RequestResponse();
        requestResponse.setStatus(200);
        requestResponse.setMessage("Successfully added new student.");*/

        return studentService.addStudent(student);

        }

}
