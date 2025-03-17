package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.User;


public interface UserRepository extends MongoRepository<User,String>{
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    @SuppressWarnings("null")
    Optional<User> findById(String id);
}
