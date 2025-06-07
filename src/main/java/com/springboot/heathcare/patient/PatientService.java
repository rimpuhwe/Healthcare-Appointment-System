package com.springboot.heathcare.patient;

import com.springboot.heathcare.clinic.Clinic;
import com.springboot.heathcare.clinic.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final ClinicRepository clinicRepository;

    public Patient createPatient(Patient patient, Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId).orElseThrow(() -> new RuntimeException("Clinic not found"));
        patient.setClinic(clinic);
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() { return patientRepository.findAll(); }
    public Patient getPatient(Long id) { return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found")); }
    public void deletePatient(Long id) { patientRepository.deleteById(id); }
}