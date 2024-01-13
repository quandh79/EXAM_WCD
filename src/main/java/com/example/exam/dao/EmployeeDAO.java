package com.example.exam.dao;

import com.example.exam.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    void createEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getAllEmployee();
}
