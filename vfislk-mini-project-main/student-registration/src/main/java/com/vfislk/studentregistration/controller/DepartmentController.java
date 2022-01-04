package com.vfislk.studentregistration.controller;

import com.vfislk.studentregistration.entity.Department;
import com.vfislk.studentregistration.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/sms")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public String ListDepartments(Model model){
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "departments";
    }
    @GetMapping("/departments/new")
    public String createDepartmentForm(Model model) {
        Department department=new Department();
        model.addAttribute("department", department);
        return "create_department";
    }
    @PostMapping("/departments")
    public String saveDepartment(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) {
       if(bindingResult.hasErrors()){
           return "create_department";
       }
       else {
           departmentService.saveDepartment(department);
           return "redirect:/sms/departments";
       }
    }
    @GetMapping("/departments/edit/{Interests}")
        public String editdepartmentForm(@PathVariable String Interests, Model model) {
            model.addAttribute("department", departmentService.getDepartmentById(Interests));
            return "edit_department";
    }
   @PostMapping("/departments/{Interests}")
    public String updateDepartment(@Valid @PathVariable String Interests,
                                @ModelAttribute("department") Department department,BindingResult bindingResult,
                                Model model) {
        if(bindingResult.hasErrors()){
            return "redirect:/sms/departments/edit/{Interests}";
        }
        else {
            Department existingDepartment = departmentService.getDepartmentById(Interests);
            existingDepartment.setDepartmentId(department.getDepartmentId());
            existingDepartment.setInterests(department.getInterests());
            existingDepartment.setDepartmentName(department.getDepartmentName());
            departmentService.updateDepartment(existingDepartment);
            return "redirect:/sms/departments";
        }
    }


    @GetMapping("/departments/{Interests}")
    public String deletedepartment(@PathVariable String Interests) {
        departmentService.deleteById(Interests);
        return "redirect:/sms/departments";
    }

}
