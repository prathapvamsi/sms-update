package com.vfislk.studentregistration.controller;

import com.vfislk.studentregistration.service.DepartmentService;
import com.vfislk.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/list")
public class NormalUserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "/studentslist")
    public String studentListDisplay(Model model){
       model.addAttribute("students",studentService.getAllStudents());
        return "studentslist";
    }
    @RequestMapping(value = "/departmentslist")
    public String departmentlist(Model model){
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "departmentlist";
    }
}
