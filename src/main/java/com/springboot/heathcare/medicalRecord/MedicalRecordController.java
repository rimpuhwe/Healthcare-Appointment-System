package com.springboot.heathcare.medicalRecord;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping("/add_new")
    public ResponseEntity<MedicalRecord> create(@RequestBody MedicalRecord record, @RequestParam Long patientId, @RequestParam Long doctorId) {
        MedicalRecord records =  medicalRecordService.createMedicalRecord(record, patientId, doctorId);
        return new ResponseEntity<>(records, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAll() {
        List<MedicalRecord> records =  medicalRecordService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> get(@PathVariable Long id) {
        MedicalRecord records =  medicalRecordService.getRecord(id);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<MedicalRecord> update(@PathVariable Long id, @RequestBody MedicalRecord record) {
        MedicalRecord records =  medicalRecordService.updateRecord(id, record);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicalRecord> delete(@PathVariable Long id) {
        medicalRecordService.deleteRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
