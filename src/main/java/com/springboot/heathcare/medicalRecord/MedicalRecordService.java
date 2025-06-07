package com.springboot.heathcare.medicalRecord;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository repository;

    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        return repository.save(medicalRecord);
    }
    public List<MedicalRecord> findAllRecords() {
        return repository.findAll();
    }
    public MedicalRecord findMedicalRecordById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Medical Record Not Found"));
    }
    public MedicalRecord updateMedicalRecord(Long id,MedicalRecord medicalRecord) {
        var oldMedicalRecord = repository.findById(id).orElseThrow(()->new RuntimeException("Medical Record Not Found"));
        medicalRecord = new MedicalRecord();
        oldMedicalRecord.setPrescription(medicalRecord.getPrescription());
        oldMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
        oldMedicalRecord.setRecordDate(medicalRecord.getRecordDate());
        return repository.save(oldMedicalRecord);

    }
    public void deleteMedicalRecord(Long id) {
        repository.deleteById(id);
    }
}
