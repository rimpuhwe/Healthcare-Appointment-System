package com.springboot.heathcare.medicalRecord;

import jakarta.validation.constraints.PastOrPresent;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link MedicalRecord}
 */
@Value
public class MedicalRecordDto {
    @Length(message = "you can't exceed 255 characters", max = 255)
    String diagnosis;
    @Length(message = "you can't exceed 500 characters", min = 0, max = 500)
    String prescription;
    @PastOrPresent
    LocalDateTime recordDate;
}