package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Issue;
import com.example.repository.IssueRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Issue reportIssue(Issue issue) {
        issue.setStatus("OPEN");
        issue.setCreatedAt(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    public List<Issue> getIssues() {
        return issueRepository.findAll();
    }

    public Optional<Issue> resolveIssue(String issueId) {
        Optional<Issue> optional = issueRepository.findById(issueId);
        if (optional.isPresent()) {
            Issue issue = optional.get();
            issue.setStatus("RESOLVED");
            issue.setResolvedAt(LocalDateTime.now());
            issueRepository.save(issue);
            return Optional.of(issue);
        }
        return Optional.empty();
    }

}
