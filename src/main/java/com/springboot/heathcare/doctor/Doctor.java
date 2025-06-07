package com.springboot.heathcare.doctor;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.heathcare.appointment.Appointment;
import com.springboot.heathcare.clinic.Clinic;
import com.springboot.heathcare.medicalRecord.MedicalRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String firstName;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String lastName;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String speciality;

    @Column(nullable = false, unique = true)
    @Email
    @NotBlank
    private String email;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("doctor-appointments")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("doctor-medicalrecords")
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
}