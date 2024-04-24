package com.example.employeemanagmentbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeemanagmentbackend.model.Employee;
import com.example.employeemanagmentbackend.model.User;
import com.example.employeemanagmentbackend.repository.EmployeeRepository;
import com.example.employeemanagmentbackend.repository.UserRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Employee addEmployeeToUser(int userId, Employee employee) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        employee.setUser(user);
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeByUserIdAndEmployeeId(int userId, int employeeId) {
        return employeeRepository.findByIdAndUserId(employeeId, userId);
    }

    @Override
    public Set<Employee> getUserEmployees(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getEmployees();
    }

    @Override
    public Employee updateEmployee(int userId, int employeeId, Employee employee) {
        Employee existingEmployee = getEmployeeByUserIdAndEmployeeId(userId, employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setLocation(employee.getLocation());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setHours(employee.getHours());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(int userId, int employeeId) {
        Employee employee = getEmployeeByUserIdAndEmployeeId(userId, employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }
}
