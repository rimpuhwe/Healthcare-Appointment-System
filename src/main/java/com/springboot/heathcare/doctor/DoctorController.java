package com.springboot.heathcare.doctor;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final ClinicService service;


    @PostMapping("/add_doctor")
    public ResponseEntity<Clinic> addDoctor(@RequestBody Clinic clinic) {
        Clinic doctors = service.addDoctor(clinic);
        return new ResponseEntity<>(doctors, HttpStatus.CREATED);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Clinic> updateDoctor(@PathVariable Long id , @RequestBody @Valid Clinic clinic) {
        Clinic doc = service.updateDoctor(id, clinic);
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Clinic>> getAllDoctors() {
        var doctors = service.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Clinic> removeDoctor(@RequestParam Long id) {
        service.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
