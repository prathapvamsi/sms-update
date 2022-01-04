package com.vfislk.studentregistration.repository;

import com.vfislk.studentregistration.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department ,String> {

}
