package com.example.employeemanagmentbackend.controller;

import com.example.employeemanagmentbackend.service.PasswordHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagmentbackend.model.Employee;
import com.example.employeemanagmentbackend.model.User;
import com.example.employeemanagmentbackend.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserService userService; // we are bringing in User Service instance

    // This is a post request, here we are going to be saving a user
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    // Gets all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    // Get one user by Id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    // Get all employees for a user by user Id
    @GetMapping("/{id}/employees")
    public Set<Employee> getUserEmployees(@PathVariable int id) {
        return userService.getUserEmployees(id);
    }
    // Add an employee to a user
    @PostMapping("/{userId}/employees")
    public User addEmployeeToUser(@PathVariable int userId, @RequestBody Employee employee) {
        return userService.addEmployeeToUser(userId, employee);
    }
    // Update an user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        user.setPassword(PasswordHash.hashPassword(user.getPassword()));
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);

    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        Optional<User> user = userService.findByEmailAndPassword(email, password);
        if (user.isPresent()) {
            session.setAttribute("user", user.get());
            return "Logged In successfully";
        }
        else {
            return "Invalid Credentials";
        }
    }
    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "Logged out successfully";
    }
}
