package com.HyScalar.EmpLeaveManagement.service;


import com.HyScalar.EmpLeaveManagement.model.LeaveRequest;
import com.HyScalar.EmpLeaveManagement.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public void applyLeave(LeaveRequest leave){

        leave.setStatus("PENDING");

        leaveRepository.save(leave);
    }

    public List<LeaveRequest> getEmployeeLeaves(String email){

        return leaveRepository.findByEmployeeEmail(email);
    }

    public List<LeaveRequest> getAllLeaves(){
        return leaveRepository.findAll();
    }

    public LeaveRequest getLeaveById(Long id){
        return leaveRepository.findById(id).orElse(null);
    }

    public void updateLeave(LeaveRequest leave){
        leaveRepository.save(leave);
    }

    public long calculateDays(LeaveRequest leave){

        return ChronoUnit.DAYS.between(
                leave.getStartDate(),
                leave.getEndDate()) + 1;
    }


    public List<LeaveRequest> getApprovedLeaves(){

        return leaveRepository.findAll()
                .stream()
                .filter(l -> "APPROVED".equals(l.getStatus()))
                .collect(Collectors.toList());
    }
}