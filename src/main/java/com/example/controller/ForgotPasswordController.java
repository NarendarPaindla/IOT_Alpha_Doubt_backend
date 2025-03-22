package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payload.PasswordResetRequest;
import com.example.payload.PasswordResetTokenRequest;
import com.example.service.PasswordResetService;

@RestController
@RequestMapping("/api/auth")
public class ForgotPasswordController {

    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody PasswordResetRequest request) {
        boolean result = passwordResetService.generateResetToken(request.getEmail());
        if (result) {
            return ResponseEntity.ok("Password reset email sent");
        } else {
            return ResponseEntity.status(404).body("User with given email not found");
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordResetTokenRequest request) {
        boolean result = passwordResetService.resetPassword(request.getToken(), request.getNewPassword());
        if (result) {
            return ResponseEntity.ok("Password reset successfully");
        } else {
            return ResponseEntity.status(400).body("Invalid or expired token");
        }
    }
}
