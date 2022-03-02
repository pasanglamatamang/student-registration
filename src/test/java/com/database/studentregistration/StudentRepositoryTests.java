package com.database.studentregistration;

import com.database.studentregistration.repository.StudentRepository;
import com.database.studentregistration.students.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.text.html.Option;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


public class StudentRepositoryTests {
    @Autowired
    private StudentRepository studentRepository;

/*    @Test
    public void testAddStudent() {
        Date date = new Date(1990, Calendar.FEBRUARY, 1);

        Student student = new Student();
        student.setId(1L);
        student.setFirstName("Tina");
        student.setLastName("Gray");
        student.setEmail("tina@gmail.com");
        student.setDob(date);

        Student savedStudent = studentRepository.save(student);

        Assertions.assertAll();
    }*/

    /*@Test
    void testShowAllStudent () {

            List<Student> allStudents = studentRepository.findAll();
            for (Student student : allStudents) {
                System.out.println(student);
            }
        }*/

/*        @Test
        public void testUpdate(){
        int id = 1;
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();
        student.setFirstName("Tina");
        student.setLastName("Cook");
        student.setEmail("tina@gmail.com");
        student.setDob(new Date(1995, Calendar.MARCH, 11));

        Student student1 = studentRepository.save(student);
        Assertions.assertAll();

        }*/

   /* @Test
    void testDelete(){
        int id = 3;
        studentRepository.deleteById(id);

        }*/


    }

