package com.vfislk.studentregistration.entity;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Component
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String interests;
    private String studentRollNumber;

    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "Allocated_Department")
    private String AllocatedDepartment;
    @Email
    @Column(name = "email")

    private String email;
    public String getInterests() {
        return interests;
    }
    public void setInterests(String interests) {
        this.interests = interests;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getAllocatedDepartment() {
        return AllocatedDepartment;
    }

    public void setAllocatedDepartment(String allocatedDepartment) {
        this.AllocatedDepartment = allocatedDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }
}
