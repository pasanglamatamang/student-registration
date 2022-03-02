package com.database.studentregistration.services;

import com.database.studentregistration.students.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {


    List<Student> findAll();


    Student addStudent(Student student);


    Optional<Student> findStudentById(Long id);


    Student findStudentByIdAndFirstName(Long id, String firstName);

    String updateStudent(Long id, Student student);

    String deleteStudent(Long id);
}
