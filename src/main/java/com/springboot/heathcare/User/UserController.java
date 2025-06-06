package com.springboot.heathcare.User;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Get all users (not really needed)
    @GetMapping
    public ResponseEntity<List<UserProfileDto>> getAllUsers() {
        List<UserProfileDto> users = userService.getAllUsers()
                .stream()
                .map(UserProfileDto::fromUser)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    //Get current user profile (based on JWT token)
    @GetMapping("/me")
    public ResponseEntity<UserProfileDto> getMyProfile(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(UserProfileDto.fromUser(user));
    }

    // Update email only
    @PatchMapping("/me/email")
    public ResponseEntity<UserProfileDto> updateEmail(
            Authentication authentication,
            @Valid @RequestBody UserEmailDto emailDto
    ) {
        String firstName = authentication.getName();
        User updatedUser = userService.updateUserEmail(firstName, emailDto);
        return ResponseEntity.ok(UserProfileDto.fromUser(updatedUser));
    }

    // Update password only
    @PatchMapping("/me/password")
    public ResponseEntity<UserProfileDto> updatePassword(
            Authentication authentication,
            @Valid @RequestBody UserPasswordDto passwordDto
    ) {
        String firstName = authentication.getName();
        User updatedUser = userService.updateUserPassword(firstName, passwordDto);
        return ResponseEntity.ok(UserProfileDto.fromUser(updatedUser));
    }


    //Delete user
    @DeleteMapping("/me/{id}")
    public ResponseEntity<String> deleteMyAccount(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User with ID " + id + " has been deleted.");
    }

}

