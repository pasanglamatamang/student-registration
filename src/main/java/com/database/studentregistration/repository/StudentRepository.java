package com.database.studentregistration.repository;

import com.database.studentregistration.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndFirstName(Long id, String firstName);

    Optional<Student> findStudentByEmail(String email);
}
