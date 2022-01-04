package com.vfislk.studentregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {
    @RequestMapping("/home")
    public String homepage(){
        return "home";
    }
}
