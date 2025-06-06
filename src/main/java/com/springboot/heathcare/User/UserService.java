package com.springboot.heathcare.User;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public User updateUserEmail(@PathVariable String firstName , @RequestBody UserEmailDto userEmailDto) {
        User user = new User();
        user.setEmail(userEmailDto.getEmail());
        return userRepository.save(user);
    }
    public User updateUserPassword(@PathVariable String firstName , @RequestBody UserPasswordDto userPasswordDto) {
        User user = new User();
        user.setPassword(userPasswordDto.getPassword());
        return userRepository.save(user);
    }
    public void deleteUser(@PathVariable Long id) {
        var user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User doesn't exist"));
        userRepository.delete(user);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
