package com.example.employeemanagmentbackend.service;


import java.util.List;
import java.util.Optional;

import com.example.employeemanagmentbackend.model.User;

public interface UserServiceInterface {
    
    public User saveUser(User user);

    public Optional<User> getUserById(int id);

    List<User> getAllUsers();

    User updateUser(int id, User user);

    void deleteUser(int id);
    
}
