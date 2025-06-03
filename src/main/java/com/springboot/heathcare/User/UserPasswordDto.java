package com.springboot.heathcare.User;

import jakarta.validation.constraints.Pattern;
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
public class UserPasswordDto implements Serializable {
    @Pattern(message = "choose the strongest password", regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$ ")
    String password;
}