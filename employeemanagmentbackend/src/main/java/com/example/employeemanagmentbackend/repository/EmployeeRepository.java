package com.example.employeemanagmentbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagmentbackend.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
        Optional<Employee> findByIdAndUserId(int id, int userId);

}
