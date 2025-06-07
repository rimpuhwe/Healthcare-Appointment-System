package com.springboot.heathcare.appointment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment, @RequestParam Long patientId, @RequestParam Long doctorId) {
        Appointment appoint =  appointmentService.createAppointment(appointment, patientId, doctorId);
        return new ResponseEntity<>(appoint, HttpStatus.OK);
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
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment appointment) {
        Appointment appointment1 = appointmentService.updateAppointment(id, appointment);
        return new ResponseEntity<>(appointment1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Appointment> delete(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
