package com.springboot.heathcare.patient;

import com.springboot.heathcare.appointment.Appointment;
import com.springboot.heathcare.clinic.Clinic;
import com.springboot.heathcare.medicalRecord.MedicalRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Long id;

    @NotEmpty(message = "this field must not be empty")
    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    @NotEmpty(message = "provide your last name ")
    private String lastName;

    @Email(message = "invalid email" , regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "must be 10-20 digits ,no whitespace")
    @NotNull(message = "provide your mobile number ")
    @Digits(integer = 20, fraction = 0)
    private String phone;

    @Column(nullable = false)
    @Past(message = "enter valid birthDate")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @OneToMany(mappedBy = "medicalRecord", orphanRemoval = true)
    private List<MedicalRecord> medicalRecords;

}