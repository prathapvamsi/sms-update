package com.vfislk.studentregistration.serviceimpl;

import com.vfislk.studentregistration.entity.Department;
import com.vfislk.studentregistration.repository.DepartmentRepository;
import com.vfislk.studentregistration.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DepartmentImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(String Interests) {
        return departmentRepository.findById(Interests).get();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteById(String Interests) {
        departmentRepository.deleteById(Interests);
    }
}
