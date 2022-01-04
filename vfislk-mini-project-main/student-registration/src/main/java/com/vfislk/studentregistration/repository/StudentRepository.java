package com.vfislk.studentregistration.repository;

import com.vfislk.studentregistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
