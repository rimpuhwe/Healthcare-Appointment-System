package com.springboot.heathcare.appointment;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springboot.heathcare.doctor.Doctor;
import com.springboot.heathcare.patient.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Appointment_id", nullable = false)
    private Long id;

    @Future(message = "appointment must be in future date")
    private LocalDateTime appointmentDate;

    @NotBlank(message = "provide the status of appointment")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus Status;

    @Column(length = 500)
    @Length(message = "Note exceed 500 characters ", min = 0, max = 500)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id_key")
    @JsonBackReference("patient-appointments")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id_key")
    @JsonBackReference("doctor-appointments")
    private Doctor doctor;



}