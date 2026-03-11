package com.HyScalar.EmpLeaveManagement.controller;

import com.HyScalar.EmpLeaveManagement.model.LeaveRequest;
import com.HyScalar.EmpLeaveManagement.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CalendarController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/calendar")
    public String leaveCalendar(Model model){

        List<LeaveRequest> approvedLeaves =
                leaveService.getApprovedLeaves();

        model.addAttribute("leaves", approvedLeaves);

        return "calendar";
    }
}