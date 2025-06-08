package com.springboot.heathcare.appointment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@PreAuthorize("hasAnyAuthority('PATIENT', 'DOCTOR')")
@RequiredArgsConstructor

public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<Appointment> create(@RequestBody AppointmentDto dto, @RequestParam Long patientId, @RequestParam String doctorName) {
        Appointment appointment =  appointmentService.createAppointment(dto, patientId, doctorName);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        List<Appointment> appointments =  appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> get(@PathVariable Long id) {
        Appointment appointment =  appointmentService.getAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody AppointmentDto appointment) {
        Appointment appointment1 = appointmentService.updateAppointment(id, appointment);
        return new ResponseEntity<>(appointment1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointment is successfully deleted ",HttpStatus.OK);
    }
}
