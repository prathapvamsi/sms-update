package com.vfislk.studentregistration.service;

import com.vfislk.studentregistration.entity.Student;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public interface StudentService {
        List<Student> getAllStudents();

        Student saveStudent(Student student);

        Student getStudentById(Long id);

        Student updateStudent(Student student);

        void deleteStudentById(Long id);
}
