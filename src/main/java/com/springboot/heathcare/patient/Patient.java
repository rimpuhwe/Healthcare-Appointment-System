package com.springboot.heathcare.patient;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.heathcare.appointment.Appointment;
import com.springboot.heathcare.clinic.Clinic;
import com.springboot.heathcare.medicalRecord.MedicalRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String firstName;

    @Column(nullable = false, length = 50)
    @NotBlank
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email @NotBlank
    private String email;

    @Column(nullable = false, length = 20, unique = true)
    @NotBlank
    private String phone;

    @Column(nullable = false)
    @Past
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("patient-appointments")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("patient-medicalrecords")
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
}