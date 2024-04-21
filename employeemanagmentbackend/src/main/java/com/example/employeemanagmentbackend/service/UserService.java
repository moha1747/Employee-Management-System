
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

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public User updateUser(int id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow();
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    //method to get all employees for a specific user
    public Set<Employee> getUserEmployees(int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user.getEmployees();
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // method to add an employee to a user
    public User addEmployeeToUser(int userId, Employee employee) {
        User user = userRepository.findById(userId).orElseThrow();
        employee.setUser(user);
        employeeRepository.save(employee);
        return user;
    }
}
