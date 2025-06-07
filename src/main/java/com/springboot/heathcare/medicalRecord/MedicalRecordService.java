package com.springboot.heathcare.medicalRecord;

import com.springboot.heathcare.doctor.Doctor;
import com.springboot.heathcare.doctor.DoctorRepository;

import com.springboot.heathcare.patient.Patient;
import com.springboot.heathcare.patient.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public MedicalRecord createMedicalRecord(MedicalRecord record, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        record.setPatient(patient);
        record.setDoctor(doctor);

        if (record.getRecordDate() == null) {
            record.setRecordDate(LocalDateTime.now());
        }

        return medicalRecordRepository.save(record);
    }

    public List<MedicalRecord> getAllRecords() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord getRecord(Long id) {
        return medicalRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Medical record not found"));
    }

    public MedicalRecord updateRecord(Long id, MedicalRecord updatedRecord) {
        MedicalRecord record = getRecord(id);
        record.setDiagnosis(updatedRecord.getDiagnosis());
        record.setPrescription(updatedRecord.getPrescription());
        return medicalRecordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }
}
