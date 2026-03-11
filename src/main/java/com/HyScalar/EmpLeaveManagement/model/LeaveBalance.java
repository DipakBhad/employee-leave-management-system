package com.HyScalar.EmpLeaveManagement.model;

import jakarta.persistence.*;

@Entity
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeEmail;

    private int vacationDays;

    private int sickDays;

    public LeaveBalance(){}

    public Long getId() {
        return id;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public int getSickDays() {
        return sickDays;
    }

    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }
}