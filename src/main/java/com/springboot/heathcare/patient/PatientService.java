package com.springboot.heathcare.patient;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("No Patient found"));
    }
    public Patient updatePatient(Long id, Patient patient) {
        var existingPatient = patientRepository.findById(id).orElseThrow(()->new RuntimeException("no patient found"));
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setEmail(patient.getEmail());
        return patientRepository.save(existingPatient);

    }
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }


}
