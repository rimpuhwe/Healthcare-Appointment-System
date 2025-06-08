package com.springboot.heathcare.appointment;

import com.springboot.heathcare.patient.Patient;
import com.springboot.heathcare.patient.PatientRepository;
import com.springboot.heathcare.doctor.Doctor;
import com.springboot.heathcare.doctor.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public Appointment createAppointment(AppointmentDto dto, Long patientId, String doctorName) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findDoctorByFirstNameContainingIgnoreCase(doctorName);

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setNotes(dto.getNotes());
        appointment.setStatus(dto.getStatus());

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        patientRepository.save(patient);
        doctorRepository.save(doctor);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointment) {
        var appoint = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        appoint.setStatus(appointment.getStatus());
        appoint.setNotes(appointment.getNotes());
        appoint.setAppointmentDate(appointment.getAppointmentDate());
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}

