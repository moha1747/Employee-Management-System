package com.example.employeemanagmentbackend.service;


import java.util.*;

import com.example.employeemanagmentbackend.model.*;

public interface UserServiceInterface {

    User saveUser(User user);

    Optional<User> getUserById(int id);

    List<User> getAllUsers();

    User updateUser(int id, User user);

    void deleteUser(int id);

    Set<Employee> getUserEmployees(int userId);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
