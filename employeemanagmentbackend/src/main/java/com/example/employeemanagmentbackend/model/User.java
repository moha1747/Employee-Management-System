package com.example.employeemanagmentbackend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Represents a user in the employee management system.
 */
@Entity
public class User {
    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;

    /**
     * The set of employees associated with the user.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Employee> employees = new HashSet<>();

    /**
     * Default constructor.
     */
    public User() {}

    /**
     * Gets the unique identifier for the user.
     * 
     * @return the user ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the user.
     * 
     * @param id the user ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the email address of the user.
     * 
     * @return the user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * 
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the hashed password of the user.
     * 
     * @return the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the hashed password of the user.
     * 
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the set of employees associated with the user.
     * 
     * @return the set of employees.
     */
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets the set of employees associated with the user.
     * 
     * @param employees the set of employees to set.
     */
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}