package com.vfislk.studentregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping(value = "/signin")
    public String loginpage(){
        return "loginform";
    }



}
