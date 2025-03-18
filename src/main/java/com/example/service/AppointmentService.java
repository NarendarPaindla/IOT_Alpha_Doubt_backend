package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Appointment;
import com.example.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("PENDING");
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByStudent(String studentId) {
        return appointmentRepository.findByStudentId(studentId);
    }

    public List<Appointment> getAppointmentsByTrainer(String trainerId) {
        return appointmentRepository.findByTrainerId(trainerId);
    }

    public Optional<Appointment> updateAppointmentStatus(String appointmentId, String status) {
        Optional<Appointment> optional = appointmentRepository.findById(appointmentId);
        if (optional.isPresent()) {
            Appointment appointment = optional.get();
            appointment.setStatus(status);
            appointmentRepository.save(appointment);
            return Optional.of(appointment);
        }
        return Optional.empty();
    }
}
