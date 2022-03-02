package com.database.studentregistration.services;

import com.database.studentregistration.repository.StudentRepository;
import com.database.studentregistration.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student findStudentByIdAndFirstName(Long id, String firstName) {
        Optional<Student> findStudent = studentRepository.findByIdAndFirstName(id, firstName);

            if(findStudent.isPresent()){
                Student student = findStudent.get();
                System.out.println("Student found: " + student);
                return student;
            }else {
                System.out.println("student not found");
            }

            return null;
        }





    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }






}
