package com.springboot.heathcare.patient;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;


    @PostMapping("/add_patient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient patients = patientService.createPatient(patient);
        return new ResponseEntity<>(patients, HttpStatus.CREATED);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id , @RequestBody @Valid Patient patient) {
        Patient patients = patientService.updatePatient(id, patient);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Patient>> getPatients() {
        var patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Patient> removePatient(@RequestParam Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
