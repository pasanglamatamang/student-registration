package com.database.studentregistration.controller;


import com.database.studentregistration.services.StudentService;
import com.database.studentregistration.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.findAll();
        return ResponseEntity.ok().body(allStudents);
    }

    //gets specific student by id
    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.findStudentById(id);
        return ResponseEntity.ok().body(student);
    }

    //gets specific students by id and first name
    @GetMapping("/students/{id}/{firstName}")
    public ResponseEntity<Student> getStudentByIdAndFirstName(@PathVariable("id") Long id, @PathVariable("firstName") String firstName) {
        Student student = studentService.findStudentByIdAndFirstName(id, firstName);
        return ResponseEntity.ok().body(student);
    }

    //add a student
    @PostMapping("/addStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student s = studentService.addStudent(student);
        return ResponseEntity.ok().body(s);
    }

    //add a list of students
    @PostMapping("/addStudents")
    public ResponseEntity<Student> addListOfStudents(@RequestBody List<Student> addStudents){
        Student student = studentService.addListOfStudents(addStudents);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok("Student updated successfully.");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }

}




