package com.example.payload;

import lombok.Data;

@Data
public class PasswordResetTokenRequest {
    private String token;
    private String newPassword;
}
