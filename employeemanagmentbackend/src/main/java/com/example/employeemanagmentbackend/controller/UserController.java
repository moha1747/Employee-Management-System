package com.example.employeemanagmentbackend.controller;

import com.example.employeemanagmentbackend.service.EmployeeService;
import com.example.employeemanagmentbackend.service.LoginDataTransfer;
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
     @Autowired
    private EmployeeService employeeService; // Autowire EmployeeService for managing employees

    // This is a post request, here we are going to be saving a user
    @PostMapping
    public User saveUser(@RequestBody User user) {
        user.setPassword(PasswordHash.hashPassword(user.getPassword()));
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
    public ResponseEntity<?> loginUser(@RequestBody LoginDataTransfer loginDT, HttpSession session) {
        Optional<User> user = userService.findByEmail(loginDT.getEmail());
        if (user.isPresent() && PasswordHash.checkPass(loginDT.getPassword(), user.get().getPassword())) {
            session.setAttribute("user", user.get());
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "Logged out successfully";
    }
    // New Employee management endpoints under a user
    @GetMapping("/{userId}/employees")
    public Set<Employee> getUserEmployees(@PathVariable int userId) {
        return userService.getUserEmployees(userId);
    }

    @PostMapping("/{userId}/employees")
    public Employee addEmployeeToUser(@PathVariable int userId, @RequestBody Employee employee) {
        return employeeService.addEmployeeToUser(userId, employee);
    }

    @GetMapping("/{userId}/employees/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable int userId, @PathVariable int employeeId) {
        return employeeService.getEmployeeByUserIdAndEmployeeId(userId, employeeId);
    }

    @PutMapping("/{userId}/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int userId, @PathVariable int employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(userId, employeeId, employee);
    }

    @DeleteMapping("/{userId}/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int userId, @PathVariable int employeeId) {
        employeeService.deleteEmployee(userId, employeeId);
    }
}
