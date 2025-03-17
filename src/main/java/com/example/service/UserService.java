package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

     @Autowired
     private UserRepository userRepository;
     @Autowired
     private PasswordEncoder passwordEncoder;

     public boolean existsByEmail(String email) {
          return userRepository.existsByEmail(email);
     }

     public boolean existsByUsername(String username) {
          return userRepository.existsByUsername(username);
     }

     public User register(User user) {
          user.setPassword(passwordEncoder.encode(user.getPassword()));
          return userRepository.save(user);
     }

     public Optional<User> findByEmail(String email) {
          return userRepository.findByEmail(email);
     }

     public Optional<User> findByUsername(String username) {
          return userRepository.findByUsername(username);
     }

     public Iterable<User> findAll() {
          return userRepository.findAll();
     }

     public Iterable<User> findAllTrainers() {
          // Return all users with role = TRAINER
          return userRepository.findAll().stream()
                    .filter(u -> u.getRole() != null && u.getRole().name().equals("TRAINER"))
                    .toList();
     }

     public Optional<User> findById(String id) {
          return userRepository.findById(id);
     }
}
