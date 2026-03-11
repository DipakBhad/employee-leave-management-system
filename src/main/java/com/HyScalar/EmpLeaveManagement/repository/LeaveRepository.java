package com.HyScalar.EmpLeaveManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.HyScalar.EmpLeaveManagement.model.LeaveRequest;
import java.util.List;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployeeEmail(String email);

}