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
    private UserService userService; // Service to handle user-related logic

    @Autowired
    private EmployeeService employeeService; // Service to handle employee-related logic

    // Endpoint to create a new user
    @PostMapping
    public User saveUser(@RequestBody User user) {
        user.setPassword(PasswordHash.hashPassword(user.getPassword())); // Hash the password before saving for security
        return userService.saveUser(user);
    }

    // Endpoint to retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to retrieve a single user by their ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // Endpoint to update an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Endpoint to delete a user by their ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    // Endpoint to register a new user with additional checks
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Check if email is already in use
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use");
        }
        user.setPassword(PasswordHash.hashPassword(user.getPassword())); // Hash the password before saving
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Endpoint to log in a user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDataTransfer loginDT, HttpSession session) {
        Optional<User> user = userService.findByEmail(loginDT.getEmail());
        // Verify user exists and password matches
        if (user.isPresent() && PasswordHash.checkPass(loginDT.getPassword(), user.get().getPassword())) {
            session.setAttribute("user", user.get()); // Store user in session
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    // Endpoint to log out a user
    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate(); // Invalidate the session to log out
        return "Logged out successfully";
    }

    // Endpoint to retrieve all employees associated with a user
    @GetMapping("/{userId}/employees")
    public Set<Employee> getUserEmployees(@PathVariable int userId) {
        return userService.getUserEmployees(userId);
    }

    // Endpoint to add a new employee to a user
    @PostMapping("/{userId}/employees")
    public Employee addEmployeeToUser(@PathVariable int userId, @RequestBody Employee employee) {
        return employeeService.addEmployeeToUser(userId, employee);
    }

    // Endpoint to retrieve a single employee by user ID and employee ID
    @GetMapping("/{userId}/employees/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable int userId, @PathVariable int employeeId) {
        return employeeService.getEmployeeByUserIdAndEmployeeId(userId, employeeId);
    }

    // Endpoint to update an employee
    @PutMapping("/{userId}/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int userId, @PathVariable int employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(userId, employeeId, employee);
    }

    // Endpoint to delete an employee
    @DeleteMapping("/{userId}/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int userId, @PathVariable int employeeId) {
        employeeService.deleteEmployee(userId, employeeId);
    }
}
