package com.HyScalar.EmpLeaveManagement.service;


import com.HyScalar.EmpLeaveManagement.model.LeaveBalance;
import com.HyScalar.EmpLeaveManagement.repository.LeaveBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveBalanceService {

    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    public LeaveBalance getBalance(String email){
        return leaveBalanceRepository.findByEmployeeEmail(email);
    }

    public void updateVacation(String email, int days){

        LeaveBalance balance =
                leaveBalanceRepository.findByEmployeeEmail(email);

        if(balance == null){
            return;
        }

        balance.setVacationDays(balance.getVacationDays() - days);

        leaveBalanceRepository.save(balance);
    }

    public void updateSickLeave(String email, int days){

        LeaveBalance balance =
                leaveBalanceRepository.findByEmployeeEmail(email);

        if(balance == null){
            return;
        }

        balance.setSickDays(balance.getSickDays() - days);

        leaveBalanceRepository.save(balance);
    }
}