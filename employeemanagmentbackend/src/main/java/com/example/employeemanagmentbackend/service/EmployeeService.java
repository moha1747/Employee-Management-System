package com.example.employeemanagmentbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeemanagmentbackend.model.Employee;
import com.example.employeemanagmentbackend.model.User;
import com.example.employeemanagmentbackend.repository.EmployeeRepository;
import com.example.employeemanagmentbackend.repository.UserRepository;

import java.util.Optional;
import java.util.Set;

/**
 * Service class for managing employees.
 */
@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Adds a new employee to a user.
     *
     * @param userId the ID of the user to whom the employee will be added.
     * @param employee the employee to be added.
     * @return the saved employee.
     * @throws RuntimeException if the user is not found.
     */
    @Override
    public Employee addEmployeeToUser(int userId, Employee employee) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        employee.setUser(user);
        return employeeRepository.save(employee);
    }

    /**
     * Retrieves an employee by their user ID and employee ID.
     *
     * @param userId the ID of the user to whom the employee belongs.
     * @param employeeId the ID of the employee.
     * @return an Optional containing the found employee, or an empty Optional if no employee was found.
     */
    @Override
    public Optional<Employee> getEmployeeByUserIdAndEmployeeId(int userId, int employeeId) {
        return employeeRepository.findByIdAndUserId(employeeId, userId);
    }

    /**
     * Retrieves all employees associated with a user.
     *
     * @param userId the ID of the user.
     * @return a set of employees associated with the user.
     * @throws RuntimeException if the user is not found.
     */
    @Override
    public Set<Employee> getUserEmployees(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getEmployees();
    }

    /**
     * Updates an existing employee.
     *
     * @param userId the ID of the user to whom the employee belongs.
     * @param employeeId the ID of the employee to be updated.
     * @param employee the employee details to update.
     * @return the updated employee.
     * @throws RuntimeException if the employee is not found.
     */
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

    /**
     * Deletes an employee.
     *
     * @param userId the ID of the user to whom the employee belongs.
     * @param employeeId the ID of the employee to be deleted.
     * @throws RuntimeException if the employee is not found.
     */
    @Override
    public void deleteEmployee(int userId, int employeeId) {
        Employee employee = getEmployeeByUserIdAndEmployeeId(userId, employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }
}
