package com.springboot.heathcare.clinic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public Clinic createClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public Clinic getClinic(Long id) {
        return clinicRepository.findById(id).orElseThrow(() -> new RuntimeException("Clinic not found"));
    }

    public Clinic updateClinic(Long id, Clinic updatedClinic) {
        Clinic clinic = getClinic(id);
        clinic.setName(updatedClinic.getName());
        clinic.setAddress(updatedClinic.getAddress());
        clinic.setPhone(updatedClinic.getPhone());
        return clinicRepository.save(clinic);
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(id);
    }
}
