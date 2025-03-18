package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Appointment;
import com.example.model.User;
import com.example.payload.AppointmentResponse;
import com.example.service.AppointmentService;
import com.example.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.bookAppointment(appointment));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByStudent(@PathVariable String studentId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByStudent(studentId);
        List<AppointmentResponse> responseList = appointments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByTrainer(@PathVariable String trainerId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByTrainer(trainerId);
        List<AppointmentResponse> responseList = appointments.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @PutMapping("/update/{appointmentId}")
    public ResponseEntity<?> updateAppointmentStatus(@PathVariable String appointmentId, @RequestParam String status) {
        Optional<Appointment> appointment = appointmentService.updateAppointmentStatus(appointmentId, status);
        if (appointment.isPresent()) {
            return ResponseEntity.ok(appointment.get());
        } else {
            return ResponseEntity.badRequest().body("Appointment not found");
        }
    }

    private AppointmentResponse mapToResponse(Appointment appointment) {
        AppointmentResponse resp = new AppointmentResponse();
        resp.setId(appointment.getId());
        resp.setStudentId(appointment.getStudentId());
        resp.setTrainerId(appointment.getTrainerId());
        resp.setAppointmentTime(appointment.getAppointmentTime());
        resp.setStatus(appointment.getStatus());

        // Look up the student user
        if (appointment.getStudentId() != null) {
            Optional<User> studentOpt = userService.findById(appointment.getStudentId());
            studentOpt.ifPresent(student -> resp.setStudentName(student.getUsername())); // <--
        }

        // Look up the trainer user
        if (appointment.getTrainerId() != null) {
            Optional<User> trainerOpt = userService.findById(appointment.getTrainerId());
            trainerOpt.ifPresent(trainer -> resp.setTrainerName(trainer.getUsername())); // <--
        }

        return resp;
    }
}
