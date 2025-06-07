package com.springboot.heathcare.clinic;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinic")
@RequiredArgsConstructor
public class ClinicController {
    private final ClinicService service;


    @PostMapping("/add_clinic")
    public ResponseEntity<Clinic> addPatient(@RequestBody Clinic clinic) {
        Clinic clinics = service.addClinic(clinic);
        return new ResponseEntity<>(clinics, HttpStatus.CREATED);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Clinic> updateClinic(@PathVariable Long id , @RequestBody @Valid Clinic clinic) {
        Clinic clinic1 = service.updateClinic(id, clinic);
        return new ResponseEntity<>(clinic1, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Clinic>> getAllClinics() {
        var doctors = service.getAllClinics();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Clinic> removeClinic(@RequestParam Long id) {
        service.deleteClinic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
