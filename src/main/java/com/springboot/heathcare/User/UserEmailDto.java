package com.springboot.heathcare.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.springboot.heathcare.User.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEmailDto implements Serializable {
    @Email(message = "provide a valid email", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")
    @NotBlank(message = "Email field is required")
    String email;
}