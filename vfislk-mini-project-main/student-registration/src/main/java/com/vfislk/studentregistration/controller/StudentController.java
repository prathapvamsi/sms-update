package com.vfislk.studentregistration.controller;

import com.vfislk.studentregistration.entity.Department;
import com.vfislk.studentregistration.entity.Student;
import com.vfislk.studentregistration.service.DepartmentService;
import com.vfislk.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/sms")
public class StudentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private Department department;

    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "create_student";
        }
        else {
            studentService.saveStudent(student);
            return "redirect:/sms/students";
        }
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@Valid @PathVariable Long id,
                                @ModelAttribute("student") Student student, BindingResult bindingResult,
                                Model model) {
        if(bindingResult.hasErrors()){
            return "redirect:/sms/students/edit/{id}";
        }
            else {
            Student existingStudent = studentService.getStudentById(id);
            existingStudent.setStudentRollNumber(student.getStudentRollNumber());
            existingStudent.setInterests(student.getInterests());
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            studentService.updateStudent(existingStudent);
            return "redirect:/sms/students";
        }
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/sms/students";
    }
    @GetMapping("/logout")
    public void logout(){

    }
}
