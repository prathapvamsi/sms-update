package com.vfislk.studentregistration.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Component
public class Department {
    @Id
    @NotEmpty
    private String Interests;
    private Long DepartmentId;
    private String departmentName;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getInterests() {
        return Interests;
    }

    public void setInterests(String interests) {
        this.Interests = interests;
    }

    public Long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.DepartmentId = departmentId;
    }
    public void aaa(){

    }
}

