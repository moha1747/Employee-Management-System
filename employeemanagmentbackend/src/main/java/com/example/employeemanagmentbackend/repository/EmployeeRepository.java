package com.example.employeemanagmentbackend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.employeemanagmentbackend.model.Employee;

/**
 * Repository interface for managing Employee entities.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Finds an employee by their ID and user ID.
     * 
     * @param id the ID of the employee.
     * @param userId the ID of the user to whom the employee belongs.
     * @return an Optional containing the found employee, or an empty Optional if no employee was found.
     */
    Optional<Employee> findByIdAndUserId(int id, int userId);
}
