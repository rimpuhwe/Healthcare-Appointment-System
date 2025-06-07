package com.springboot.heathcare.patient;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;

    public Doctor createPatient(Doctor doctor) {
        return patientRepository.save(doctor);
    }
    public List<Doctor> findAllPatients() {
        return patientRepository.findAll();
    }
    public Doctor findPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("No Patient found"));
    }
    public Doctor updatePatient(Long id, Doctor doctor) {
        var existingPatient = patientRepository.findById(id).orElseThrow(()->new RuntimeException("no patient found"));
        existingPatient.setFirstName(doctor.getFirstName());
        existingPatient.setLastName(doctor.getLastName());
        existingPatient.setDateOfBirth(doctor.getDateOfBirth());
        existingPatient.setPhone(doctor.getPhone());
        existingPatient.setEmail(doctor.getEmail());
        return patientRepository.save(existingPatient);

    }
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }


}
