package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Issue;

public interface IssueRepository extends MongoRepository<Issue,String> {
    List<Issue> findByStudentId(String studentId);
}
