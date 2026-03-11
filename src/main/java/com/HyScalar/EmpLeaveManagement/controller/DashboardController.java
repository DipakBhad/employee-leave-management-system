package com.HyScalar.EmpLeaveManagement.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {

        if(authentication.getAuthorities().toString().contains("MANAGER")) {
            return "redirect:/manager/dashboard";
        }

        return "redirect:/employee/dashboard";
    }
}