package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Doubt;

public interface DoubtRepository extends MongoRepository<Doubt,String> {
    List<Doubt> findByStudentId(String studentId);
    
}
