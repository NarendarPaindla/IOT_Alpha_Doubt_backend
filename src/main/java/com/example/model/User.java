package com.example.model;

import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private String gender;
    private String programLevel;
    private String degreeLevel;
    private String academicYear;
    private String university;
    private String resetToken;
    private LocalDateTime resetTokenExpiry;
}
