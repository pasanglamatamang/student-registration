package com.database.studentregistration.services;

import com.database.studentregistration.repository.StudentRepository;
import com.database.studentregistration.students.Student;
import com.database.studentregistration.util.DuplicateEmailException;
import com.database.studentregistration.util.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Long id) throws Exception {
        if(isStudentExists(id)){
            studentRepository.findById(id);
        }
        return null;
    }

    private boolean isStudentExists(Long id) throws Exception {
        if (!studentRepository.findById(id).isPresent()) {
            throw new StudentNotFoundException("We can not find the student with id: " + id + ". Please, search again.");
        }
        return false;

    }

    @Override
    public Student findStudentByIdAndFirstName(Long id, String firstName) {
        Optional<Student> findStudent = studentRepository.findByIdAndFirstName(id, firstName);

        if (findStudent.isPresent()) {
            Student student = findStudent.get();
            System.out.println("Student found: " + student);
            return student;
        } else {
            System.out.println("student not found");
        }

        return null;
    }


    @Override
    public Student addStudent(Student student) throws Exception {
        if (!isEmailExists(student.getEmail())) {
            return studentRepository.save(student);
        }
        return null;
    }

    private boolean isEmailExists(String email) throws Exception {
        if (studentRepository.findStudentByEmail(email).isPresent()) {
            throw new DuplicateEmailException("This email is already registered. Please enter another email");
        }
        return false;

    }

    @Override
    public String updateStudent(Long id, Student student) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.save(student);
        }

        return null;
    }

    @Override
    public String deleteStudent(Long id) throws Exception {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
        }else {
            throw new StudentNotFoundException("Student with the id: " + id + " cannot be found and deleted.");
        }
        return null;
    }

    @Override
    public Student addListOfStudents(List<Student> addStudents) throws Exception {
       /*for(Student student : addStudents){
           if (isEmailExists(student.getEmail())){
               throw new DuplicateEmailException("duplicate  email found");
           }
       }
       studentRepository.saveAll(addStudents);*/
/*        for(Student student : addStudents ){
            if(!findStudentByEmail(student.getEmail()).isPresent()){
                studentRepository.save(student);
            }else {
                throw new DuplicateEmailException("This email: " + student.getEmail() + " is already registered. Please enter another email");
            }
        }*/
        addStudents.stream().parallel().forEach(student -> {
            try {
                if (findStudentByEmail(student.getEmail()).isPresent()){
                    throw new DuplicateEmailException("This email: " + student.getEmail() + " is already registered. Please enter another email.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            studentRepository.save(student);
        });
        return null;
    }

    @Override
    public Optional<Student> findStudentByEmail(String email) {
        Optional<Student> student = studentRepository.findStudentByEmail(email);
        if (student.isPresent()) {
            return student;
        }
        return null;
    }


}
