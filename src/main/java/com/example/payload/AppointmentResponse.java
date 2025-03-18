package com.example.payload;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private String id;
    private String studentId;
    private String studentName;
    private String trainerId;
    private String trainerName;
    private LocalDateTime appointmentTime;
    private String status;

    public void setStudentUsername(String studentName) {
        this.studentName = studentName;
    }

    public void setTrainerUsername(String trainerName) {
       
        this.trainerName = trainerName;
    }
}
