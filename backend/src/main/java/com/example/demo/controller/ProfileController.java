package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profiles") // Đường dẫn này phải khớp với trình duyệt
public class ProfileController {

    private final ProfileRepository repository;

    // Constructor Injection (Giúp Spring nhận diện Repository)
    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        return repository.findAll();
    }
}