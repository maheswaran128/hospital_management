package com.spring.hospital.controller;

import com.spring.hospital.model.Doctor;
import com.spring.hospital.service.DoctorService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private final PasswordEncoder passwordEncoder;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Signup endpoint
    @PostMapping("/signup")
    public String signup(@RequestBody Doctor doctor) {
        // Check if username already exists
        if (doctorService.existsByUsername(doctor.getUsername())) {
            return "Doctor with this username already exists!";
        }

        // Encrypt password and save the doctor
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorService.saveDoctor(doctor);
        return "Doctor signed up successfully!";
    }

    // Signin endpoint
    @PostMapping("/signin")
    public String signin(@RequestBody Doctor doctor) {
        // Check if the doctor exists in the database
        Doctor existingDoctor = doctorService.findByUsername(doctor.getUsername());
        
        if (existingDoctor == null) {
            return "Doctor not found!";
        }

        // Check if password matches
        if (passwordEncoder.matches(doctor.getPassword(), existingDoctor.getPassword())) {
            return "Doctor signed in successfully!";
        } else {
            return "Invalid username or password!";
        }
    }
}
