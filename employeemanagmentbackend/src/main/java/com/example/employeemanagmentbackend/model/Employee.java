package com.example.employeemanagmentbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee {
     /**
     * The unique identifier for the employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String location;
    private String hours;

    /**
     * The user to whom the employee belongs.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

   /**
     * Default constructor.
     */
    public Employee() {}

    /**
     * Gets the unique identifier for the employee.
     * 
     * @return the employee ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the employee.
     * 
     * @param id the employee ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the employee.
     * 
     * @return the employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     * 
     * @param firstName the first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the employee.
     * 
     * @return the employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     * 
     * @param lastName the last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the employee.
     * 
     * @return the employee's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the employee.
     * 
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the position or job title of the employee.
     * 
     * @return the employee's position.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the position or job title of the employee.
     * 
     * @param position the position to set.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets the location where the employee works.
     * 
     * @return the employee's location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location where the employee works.
     * 
     * @param location the location to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the working hours of the employee.
     * 
     * @return the employee's working hours.
     */
    public String getHours() {
        return hours;
    }

    /**
     * Sets the working hours of the employee.
     * 
     * @param hours the working hours to set.
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * Gets the user to whom the employee belongs.
     * 
     * @return the user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user to whom the employee belongs.
     * 
     * @param user the user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }
}