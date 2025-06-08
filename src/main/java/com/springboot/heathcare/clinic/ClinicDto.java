package com.springboot.heathcare.clinic;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link Clinic}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicDto  {
    @NotNull
    String name;
    @NotNull
    String address;
    @NotNull
    @Digits(integer = 20, fraction = 20)
    String phone;
}