package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "issues")
public class Issue {
    @Id
    private String id;
    private String studentId;
    private String trainerId;
    private String issueDescription;
    private String status; // e.g., OPEN, IN_PROGRESS, RESOLVED
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;
}
