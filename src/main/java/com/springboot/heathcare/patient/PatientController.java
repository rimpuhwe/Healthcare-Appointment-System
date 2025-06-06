package com.springboot.heathcare.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/add_new")
    public ResponseEntity<Patient> create(@RequestBody Patient patient, @RequestParam Long clinicId) {
        Patient patient1 =  patientService.createPatient(patient, clinicId);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Long id) {
        Patient patient1 = patientService.getPatient(id);
        return new ResponseEntity<>(patient1, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        Patient patient1 = patientService.updatePatient(id, patient);
        return new ResponseEntity<>(patient1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> delete(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

