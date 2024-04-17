package com.example.employeemanagmentbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagmentbackend.model.Employee;
import com.example.employeemanagmentbackend.model.User;
import com.example.employeemanagmentbackend.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserService userService; // we are bringing in User Service instance

    // This is a post request, here are we going to be saving a user
    @PostMapping
    public User savUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    // Gets all user
    @GetMapping
    public List<User> getAllEmployees() {
        return userService.getAllUsers();
    }
    // Get one user by Id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    //here, we are going to be updating an user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
