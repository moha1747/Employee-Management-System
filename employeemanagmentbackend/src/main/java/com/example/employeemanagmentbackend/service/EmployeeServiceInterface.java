package com.example.employeemanagmentbackend.service;

import java.util.Set; // Use Set instead of List to avoid duplicates
import java.util.Optional;

import com.example.employeemanagmentbackend.model.Employee;

public interface EmployeeServiceInterface {
    Employee addEmployeeToUser(int userId, Employee employee);
    Optional<Employee> getEmployeeByUserIdAndEmployeeId(int userId, int employeeId);
    Set<Employee> getUserEmployees(int userId);
    Employee updateEmployee(int userId, int employeeId, Employee employee);
    void deleteEmployee(int userId, int employeeId);
}
