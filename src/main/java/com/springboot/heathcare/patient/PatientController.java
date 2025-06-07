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
    public ResponseEntity<Doctor> addPatient(@RequestBody Doctor doctor) {
        Doctor patients = patientService.createPatient(doctor);
        return new ResponseEntity<>(patients, HttpStatus.CREATED);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Doctor> updatePatient(@PathVariable Long id , @RequestBody @Valid Doctor doctor) {
        Doctor patients = patientService.updatePatient(id, doctor);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Doctor>> getPatients() {
        var patients = patientService.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Doctor> removePatient(@RequestParam Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
