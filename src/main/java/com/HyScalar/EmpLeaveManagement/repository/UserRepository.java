package com.HyScalar.EmpLeaveManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.HyScalar.EmpLeaveManagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}