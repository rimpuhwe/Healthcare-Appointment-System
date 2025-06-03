package com.springboot.heathcare.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.springboot.heathcare.User.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{
    @NotBlank(message = "fill in this field")
    String firstName;
    @NotBlank(message = "fill in this field")
    String lastName;
    @Email(message = "provide a valid email", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")
    @NotBlank(message = "Email field is required")
    String email;
    @Pattern(message = "choose the strongest password", regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$ ")
    String password;
}