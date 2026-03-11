package com.HyScalar.EmpLeaveManagement.repository;

import com.HyScalar.EmpLeaveManagement.model.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeaveBalanceRepository
        extends JpaRepository<LeaveBalance, Long> {

    LeaveBalance findByEmployeeEmail(String email);

}