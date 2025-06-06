package com.springboot.heathcare.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "fill in this field")
    private String firstName;

    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message = "fill in this field")
    private String lastName;

    @NotBlank(message = "Email field is required")
    @Email(message = "Invalid email", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    @Pattern(message = "choose the strongest password", regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$ ")
    private String password;

}