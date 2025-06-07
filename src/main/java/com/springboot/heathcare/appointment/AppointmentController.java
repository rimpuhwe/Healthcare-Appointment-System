package com.springboot.heathcare.appointment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService service;


    @PostMapping("/add_Appointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        Appointment appointments = service.addAppointment(appointment);
        return new ResponseEntity<>(appointments, HttpStatus.CREATED);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id , @RequestBody @Valid Appointment appointment) {
        Appointment appoint  = service.updateAppointment(id, appointment);
        return new ResponseEntity<>(appoint, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        var appointments = service.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Appointment> removeAppointment(@RequestParam Long id) {
        service.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
