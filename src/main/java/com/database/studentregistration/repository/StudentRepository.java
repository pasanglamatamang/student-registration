package com.database.studentregistration.repository;

import com.database.studentregistration.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
