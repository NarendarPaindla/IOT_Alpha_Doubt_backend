package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Issue;
import com.example.service.IssueService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/report")
    public ResponseEntity<Issue> reportIssue(@RequestBody Issue issue) {
        return ResponseEntity.ok(issueService.reportIssue(issue));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getIssues() {
        return ResponseEntity.ok(issueService.getIssues());
    }

    @PutMapping("/resolve/{issueId}")
    public ResponseEntity<?> resolveIssue(@PathVariable String issueId) {
        Optional<Issue> issue = issueService.resolveIssue(issueId);
        if (issue.isPresent()) {
            return ResponseEntity.ok(issue.get());
        } else {
            return ResponseEntity.badRequest().body("Issue not found");
        }
    }
}
