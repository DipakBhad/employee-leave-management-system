package com.HyScalar.EmpLeaveManagement.controller;

import com.HyScalar.EmpLeaveManagement.model.LeaveRequest;
import com.HyScalar.EmpLeaveManagement.service.LeaveBalanceService;
import com.HyScalar.EmpLeaveManagement.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/apply")
    public String applyLeaveForm(Model model){

        model.addAttribute("leave", new LeaveRequest());

        return "apply-leave";
    }

    @PostMapping("/apply")
    public String applyLeave(@ModelAttribute LeaveRequest leave,
                             Authentication authentication){

        leave.setEmployeeEmail(authentication.getName());

        leaveService.applyLeave(leave);

        return "redirect:/employee/dashboard";
    }

    @GetMapping("/history")
    public String leaveHistory(Model model,
                               Authentication authentication){

        String email = authentication.getName();

        model.addAttribute("leaves",
                leaveService.getEmployeeLeaves(email));

        return "leave-history";
    }

    @Autowired
    private LeaveBalanceService leaveBalanceService;

    @GetMapping("/balance")
    public String leaveBalance(Model model,
                               Authentication authentication){

        String email = authentication.getName();

        model.addAttribute("balance",
                leaveBalanceService.getBalance(email));

        return "leave-balance";
    }


}