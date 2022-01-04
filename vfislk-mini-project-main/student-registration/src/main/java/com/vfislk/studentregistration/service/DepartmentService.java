package com.vfislk.studentregistration.service;

import com.vfislk.studentregistration.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DepartmentService {
    List<Department> getAllDepartments();
    Department saveDepartment(Department department);
    Department getDepartmentById(String Interests);

    Department updateDepartment(Department department);

    void deleteById(String Interests);
}
