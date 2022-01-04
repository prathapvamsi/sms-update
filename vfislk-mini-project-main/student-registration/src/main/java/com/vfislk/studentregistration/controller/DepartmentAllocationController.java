package com.vfislk.studentregistration.controller;

import com.vfislk.studentregistration.entity.Department;
import com.vfislk.studentregistration.entity.Student;
import com.vfislk.studentregistration.repository.StudentRepository;
import com.vfislk.studentregistration.service.DepartmentService;
import com.vfislk.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ListIterator;

@Controller
public class DepartmentAllocationController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private StudentService studentService;
    @GetMapping("sms/students/allocate/{id}")
    public String editStudentForm(@PathVariable Long id ) {
        Student existingStudent1=studentService.getStudentById(id);
        Department existingDepartment1=departmentService.getDepartmentById(existingStudent1.getInterests());
        existingStudent1.setAllocatedDepartment(existingDepartment1.getDepartmentName());
        studentService.updateStudent(existingStudent1);
        return "redirect:/sms/students";
    }
}