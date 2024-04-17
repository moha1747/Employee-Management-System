package com.example.employeemanagmentbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagmentbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
