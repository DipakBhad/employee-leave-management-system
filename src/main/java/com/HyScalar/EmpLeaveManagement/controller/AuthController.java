package com.HyScalar.EmpLeaveManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.HyScalar.EmpLeaveManagement.model.User;
import com.HyScalar.EmpLeaveManagement.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;   // ⭐ Missing injection

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}