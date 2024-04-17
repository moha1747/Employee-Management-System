package com.example.employeemanagmentbackend.model;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String location;
    private String hours;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }
    public String getHours() { return hours; }
    public void setHours(String hours) { this.hours = hours; }
}
