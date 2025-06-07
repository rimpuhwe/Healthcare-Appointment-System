package com.springboot.heathcare.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Doctor, Long> {
}