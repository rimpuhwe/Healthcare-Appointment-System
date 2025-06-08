package com.springboot.heathcare.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Patient}
 */
@Value
public class PatientDto  {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @Email
    @NotBlank
    String email;
    @NotBlank
    String phone;
    @Past
    LocalDate dateOfBirth;
}