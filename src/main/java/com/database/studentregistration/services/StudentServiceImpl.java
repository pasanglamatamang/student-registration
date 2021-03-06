package com.database.studentregistration.services;

import com.database.studentregistration.repository.StudentRepository;
import com.database.studentregistration.students.Student;
import com.database.studentregistration.util.DuplicateEmailException;
import com.database.studentregistration.util.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service @Slf4j
public class StudentServiceImpl implements StudentService, UserDetailsService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Student> student = studentRepository.findStudentByEmail(email);
        if(student == null){
            log.error("student not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("Student found in the database: {}", email);
        }
        return null; // todo: returns user tara idea vayena yo
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Long id) throws Exception {
        log.info("Fetching student {}", id);
        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id);
        }else {
            throw new StudentNotFoundException("Student with id: " + id + " not found.");
        }
    }

/*    private boolean isStudentExists(Long id) throws Exception {
        if (!studentRepository.findById(id).isPresent()) {
            throw new StudentNotFoundException("We can not find the student with id: " + id + ". Please, search again.");
        }
        return false;

    }*/

    @Override
    public Student findStudentByIdAndFirstName(Long id, String firstName) {
        return studentRepository.findByIdAndFirstName(id, firstName).get();

//        if (findStudent.isPresent()) {
//            Student student = findStudent.get();
//            System.out.println("Student found: " + student);
//            return student;
//        } else {
//            System.out.println("student not found");
//        }
//
//        return null;
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
        } else {
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
                if (findStudentByEmail(student.getEmail()).isPresent()) {
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



/*    @Override
    public List<Student> studentMarksAbove(int marks){
//        List<Student> allStudent = studentRepository.findAll();
        return studentRepository.findAll().stream().filter(student -> student.getMarks() > marks).collect(Collectors.toList());
//        return studentList;

    }

    @Override
    public List<Student> studentMarksBelow(int marks){
        return studentRepository.findAll().stream().filter(student -> student.getMarks() < marks).collect(Collectors.toList());
//        return studentList;

    }*/


}
