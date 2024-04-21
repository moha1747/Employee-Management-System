package com.example.employeemanagmentbackend.service;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHash {
    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    public static boolean checkPassword(String plainPassword, String hashPassword){
        return BCrypt.checkpw(plainPassword, hashPassword);
    }
}
