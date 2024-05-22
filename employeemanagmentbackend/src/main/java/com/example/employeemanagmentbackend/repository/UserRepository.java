package com.example.employeemanagmentbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.employeemanagmentbackend.model.User;

import java.util.Optional;

/**
 * Repository interface for managing User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Finds a user by their email and password.
     * 
     * @param email the email of the user.
     * @param password the password of the user.
     * @return an Optional containing the found user, or an empty Optional if no user was found.
     */
    Optional<User> findByEmailAndPassword(String email, String password);

    /**
     * Finds a user by their email.
     * 
     * @param email the email of the user.
     * @return an Optional containing the found user, or an empty Optional if no user was found.
     */
    Optional<User> findByEmail(String email);
}
