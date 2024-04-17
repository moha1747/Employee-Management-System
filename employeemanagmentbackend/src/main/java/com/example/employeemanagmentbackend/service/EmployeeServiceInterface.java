package com.example.employeemanagmentbackend.service;

import java.util.List;
import java.util.Optional;

import com.example.employeemanagmentbackend.model.Employee;

public interface EmployeeServiceInterface {
    public Employee saveEmployee(Employee employee);
    public Optional<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

}
