package com.springboot.heathcare.clinic;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.heathcare.doctor.Doctor;
import com.springboot.heathcare.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 20)
    private String phone;

    @OneToMany(mappedBy = "clinic", orphanRemoval = true)
    @JsonManagedReference("clinic-patients")
    private List<Patient> patient;

    @OneToMany(mappedBy = "clinic", orphanRemoval = true)
    @JsonManagedReference("clinic-doctors")
    private List<Doctor> doctor;

}