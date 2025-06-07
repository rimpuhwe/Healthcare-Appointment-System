package com.springboot.heathcare.appointment;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private AppointmentRepository repository;

    public Appointment addAppointment(Appointment appointment) {

        return repository.save(appointment);
    }
    public Appointment getAppointmentById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("no appointment found"));
    }
    public List<Appointment> getAllAppointments() {

        return repository.findAll();
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        var oldAppointment = repository.findById(id).orElseThrow(()-> new RuntimeException("Appointment not found"));
        appointment = new Appointment();
        oldAppointment.setAppointmentDate(appointment.getAppointmentDate());
        oldAppointment.setNotes(appointment.getNotes());
        oldAppointment.setStatus(appointment.getStatus());

        return repository.save(oldAppointment);
    }
    public void deleteAppointment(Long id) {

        repository.deleteById(id);
    }



}
