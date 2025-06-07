package com.springboot.heathcare.medicalRecord;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService service;

    @PostMapping("/new")
    public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody @Valid MedicalRecord medicalRecord) {
        var savedMedicalRecord = service.addMedicalRecord(medicalRecord);
        return new ResponseEntity<>(savedMedicalRecord, HttpStatus.CREATED);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<MedicalRecord> removeMedicalRecord(@RequestParam Long id) {
        service.deleteMedicalRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long id, @RequestBody @Valid MedicalRecord medicalRecord) {
        var updatedMedicalRecord = service.updateMedicalRecord(id, medicalRecord);
        return new ResponseEntity<>(updatedMedicalRecord, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getMedicalRecords() {
        var records = service.findAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<MedicalRecord> getMedicalRecordById(@RequestParam Long id) {
        var medicalRecord = service.findMedicalRecordById(id);
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }
}
