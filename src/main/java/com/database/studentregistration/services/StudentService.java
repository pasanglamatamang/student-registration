package com.database.studentregistration.services;

import com.database.studentregistration.students.Student;

import java.util.List;

public interface StudentService {


    List<Student> findAll();


    Student addStudent(Student student);
}
