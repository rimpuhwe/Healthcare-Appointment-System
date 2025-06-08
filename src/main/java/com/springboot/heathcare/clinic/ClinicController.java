package com.springboot.heathcare.clinic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @PostMapping("/create")
    public ResponseEntity<Clinic> create(@RequestBody ClinicDto dto) {
        Clinic clinics =  clinicService.createClinic(dto);
        return new ResponseEntity<>(clinics, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Clinic>> getAll() {
        List<Clinic> clinic = clinicService.getAllClinics();
        return new ResponseEntity<>(clinic, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clinic> get(@PathVariable Long id) {
        Clinic clinic= clinicService.getClinic(id);
        return new ResponseEntity<>(clinic, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Clinic> update(@PathVariable Long id, @RequestBody ClinicDto clinic) {
        Clinic updated = clinicService.updateClinic(id, clinic);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clinicService.deleteClinic(id);
        return new ResponseEntity<>("Clinic is deleted successful",HttpStatus.OK);
    }
}

