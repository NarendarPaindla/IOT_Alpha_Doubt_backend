package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "announcements")
public class Announcement {
    @Id
    private String id;
    private String trainerId;
    private String announcementText;
    private LocalDateTime createdAt;
}
