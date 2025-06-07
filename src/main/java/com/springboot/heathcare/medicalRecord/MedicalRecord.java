package com.springboot.heathcare.medicalRecord;

import com.springboot.heathcare.doctor.Doctor;
import com.springboot.heathcare.patient.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id", nullable = false)
    private Long id;

    @Length(message = "you can't exceed 255 characters", max = 255)
    @Column(nullable = false)
    private String diagnosis;

    @Length(message = "you can't exceed 500 characters", min = 0, max = 500)
    @Column(length = 500)
    private String prescription;

    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime recordDate;

    @ManyToOne
    @JoinColumn(name = "patient_id_key")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id_key")
    private Doctor doctor;

}