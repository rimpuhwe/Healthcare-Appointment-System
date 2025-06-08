package com.springboot.heathcare.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Doctor}
 */
@Value
public class DoctorDto  {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotBlank
    String speciality;
    @Email
    @NotBlank
    String email;
}