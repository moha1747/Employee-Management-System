package com.example.employeemanagmentbackend.service;


import java.util.*;

import com.example.employeemanagmentbackend.model.*;

public interface UserServiceInterface {
    
    public User saveUser(User user);

    public Optional<User> getUserById(int id);

    List<User> getAllUsers();

    User updateUser(int id, User user);

    void deleteUser(int id);

    public Set<Employee> getUserEmployees(int userId);
    
}
