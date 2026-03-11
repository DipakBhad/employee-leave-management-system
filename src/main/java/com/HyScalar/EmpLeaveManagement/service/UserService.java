package com.HyScalar.EmpLeaveManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HyScalar.EmpLeaveManagement.model.User;
import com.HyScalar.EmpLeaveManagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}