package com.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;
    private String studentId;
    private String trainerId;
    private LocalDateTime appointmentTime;
    private String status; // e.g., PENDING, ACCEPTED, REJECTED, RESCHEDULED
}
