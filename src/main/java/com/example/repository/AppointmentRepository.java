package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Appointment;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByStudentId(String studentId);

    List<Appointment> findByTrainerId(String trainerId);
}
