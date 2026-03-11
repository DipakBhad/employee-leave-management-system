package com.HyScalar.EmpLeaveManagement.controller;

import com.HyScalar.EmpLeaveManagement.model.LeaveRequest;
import com.HyScalar.EmpLeaveManagement.service.LeaveBalanceService;
import com.HyScalar.EmpLeaveManagement.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/dashboard")
    public String managerDashboard() {
        return "manager-dashboard";
    }

    @GetMapping("/leave-requests")
    public String viewRequests(Model model){
        model.addAttribute("leaves", leaveService.getAllLeaves());
        return "manager-leave-requests";
    }

    @GetMapping("/reject/{id}")
    public String rejectLeave(@PathVariable Long id){

        LeaveRequest leave = leaveService.getLeaveById(id);

        if(leave == null){
            return "redirect:/manager/leave-requests";
        }

        leave.setStatus("REJECTED");

        leaveService.updateLeave(leave);

        return "redirect:/manager/leave-requests";
    }

    @Autowired
    private LeaveBalanceService leaveBalanceService;

    @GetMapping("/approve/{id}")
    public String approveLeave(@PathVariable Long id){

        LeaveRequest leave = leaveService.getLeaveById(id);

        if(leave == null){
            return "redirect:/manager/leave-requests";
        }

        leave.setStatus("APPROVED");

        long days = 0;

        if(leave.getStartDate() != null && leave.getEndDate() != null){
            days = leaveService.calculateDays(leave);
        }

        if("Vacation".equalsIgnoreCase(leave.getLeaveType())){
            leaveBalanceService.updateVacation(
                    leave.getEmployeeEmail(),
                    (int) days);
        }

        if("Sick Leave".equalsIgnoreCase(leave.getLeaveType())){
            leaveBalanceService.updateSickLeave(
                    leave.getEmployeeEmail(),
                    (int) days);
        }

        leaveService.updateLeave(leave);

        return "redirect:/manager/leave-requests";
    }
}