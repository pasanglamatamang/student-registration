package com.database.studentregistration.services;

import com.database.studentregistration.students.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();


    Student addStudent(Student student) throws Exception;


    Optional<Student> findStudentById(Long id) throws Exception;


    Student findStudentByIdAndFirstName(Long id, String firstName);

    String updateStudent(Long id, Student student);

    String deleteStudent(Long id) throws Exception;


    Student addListOfStudents(List<Student> addStudents) throws Exception;

    Optional<Student> findStudentByEmail(String email);


/*    List<Student> studentMarksAbove(int marks);

    List<Student> studentMarksBelow(int marks);*/
}
