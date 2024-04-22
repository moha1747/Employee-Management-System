package com.example.employeemanagmentbackend.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHash {


        // Method to hash a password
        public static String hashPassword(String plainTextPassword){
            return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
        }

        // Method to check a password
        public static boolean checkPass(String plainPassword, String hashedPassword) {
            return BCrypt.checkpw(plainPassword, hashedPassword);
        }
    }

