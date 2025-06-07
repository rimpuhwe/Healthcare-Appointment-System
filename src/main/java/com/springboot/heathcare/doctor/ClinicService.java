package com.springboot.heathcare.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private DoctorRepository doctorRepository;

    public Clinic addDoctor(Clinic clinic) {
        return doctorRepository.save(clinic);
    }
    public Clinic getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(()->new RuntimeException("no doctor found"));
    }
    public List<Clinic> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Clinic updateDoctor(Long id, Clinic clinic) {
        var oldDoctor = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("Doctor not found"));
        clinic = new Clinic();
        oldDoctor.setFirstName(clinic.getFirstName());
        oldDoctor.setLastName(clinic.getLastName());
        oldDoctor.setEmail(clinic.getEmail());
        oldDoctor.setSpeciality(clinic.getSpeciality());
        return doctorRepository.save(oldDoctor);
    }
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }



}
