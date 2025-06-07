package com.springboot.heathcare.doctor;

import com.springboot.heathcare.appointment.Appointment;
import com.springboot.heathcare.medicalRecord.MedicalRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private  String firstName;
    @Column(nullable = false, length = 50)
    private  String lastName;
    @Column(length = 100)
    private  String speciality;
    @Column(nullable = false, unique = true)
    @Email(message = "Invalid email" , regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")
    private  String email;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments ;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private com.springboot.heathcare.clinic.Clinic clinic;

    @OneToMany(mappedBy = "clinic", orphanRemoval = true)
    private List<MedicalRecord> medicalRecords = new ArrayList<>();

}