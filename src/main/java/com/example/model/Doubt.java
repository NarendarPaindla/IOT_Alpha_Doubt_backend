package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "doubts")
public class Doubt {
    @Id
    private String id;
    private String studentId;
    private String trainerId;
    private String doubtText;
    private LocalDateTime createdAt;
    private List<Reply> replies = new ArrayList<>();

    @Data
    public static class Reply {
        private String trainerId;
        private String replyText;
        private LocalDateTime repliedAt;
    }
}
