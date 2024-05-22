package com.example.employeemanagmentbackend.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.employeemanagmentbackend.model.User;
import com.example.employeemanagmentbackend.model.Employee;
import com.example.employeemanagmentbackend.repository.UserRepository;
import com.example.employeemanagmentbackend.repository.EmployeeRepository;

/**
 * Service class for managing users.
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Saves a user.
     *
     * @param user the user to save.
     * @return the saved user.
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user.
     * @return an Optional containing the found user, or an empty Optional if no user was found.
     */
    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all users, sorted by ID in descending order.
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    /**
     * Updates a user.
     *
     * @param id the ID of the user to update.
     * @param user the user details to update.
     * @return the updated user.
     */
    @Override
    public User updateUser(int id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow();
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        return userRepository.save(userToUpdate);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to delete.
     */
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Retrieves all employees associated with a user.
     *
     * @param userId the ID of the user.
     * @return a set of employees associated with the user.
     */
    public Set<Employee> getUserEmployees(int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user.getEmployees();
    }

    /**
     * Finds a user by their email and password.
     *
     * @param email the email of the user.
     * @param password the password of the user.
     * @return an Optional containing the found user, or an empty Optional if no user was found.
     */
    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Finds a user by their email.
     *
     * @param email the email of the user.
     * @return an Optional containing the found user, or an empty Optional if no user was found.
     */
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Adds an employee to a user.
     *
     * @param userId the ID of the user to whom the employee will be added.
     * @param employee the employee to be added.
     * @return the user after adding the employee.
     */
    public User addEmployeeToUser(int userId, Employee employee) {
        User user = userRepository.findById(userId).orElseThrow();
        employee.setUser(user);
        employeeRepository.save(employee);
        return user;
    }
}
