package com.springboot.heathcare.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/new")
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor, @RequestParam Long clinicId) {
        Doctor doc = doctorService.createDoctor(doctor, clinicId);
        return new ResponseEntity<>(doc, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Long id) {
        Doctor doc =  doctorService.getDoctor(id);
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Doctor> update(@RequestParam Long id, @RequestBody Doctor doctor) {
        Doctor doc = doctorService.updateDoctor(id, doctor);
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
