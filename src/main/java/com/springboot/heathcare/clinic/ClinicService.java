package com.springboot.heathcare.clinic;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private ClinicRepository repository;

    public Clinic addClinic(Clinic clinic) {

        return repository.save(clinic);
    }
    public Clinic getClinicById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("no clinic found"));
    }
    public List<Clinic> getAllClinics() {

        return repository.findAll();
    }

    public Clinic updateClinic(Long id, Clinic clinic) {
        var oldClinic = repository.findById(id).orElseThrow(()-> new RuntimeException("Clinic not found"));
        clinic = new Clinic();
        oldClinic.setName(clinic.getName());
        oldClinic.setAddress(clinic.getAddress());
        oldClinic.setPhone(clinic.getPhone());

        return repository.save(oldClinic);
    }
    public void deleteClinic(Long id) {
        repository.deleteById(id);
    }



}
