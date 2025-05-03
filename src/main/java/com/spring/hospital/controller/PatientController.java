package com.spring.hospital.controller;

import com.spring.hospital.model.Patient;
import com.spring.hospital.service.PatientService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;
    private final PasswordEncoder passwordEncoder;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Signup
    @PostMapping("/signup")
    public String signup(@RequestBody Patient patient) {
        if (patientService.existsByUsername(patient.getUsername())) {
            return "Patient with this username already exists!";
        }

        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patientService.savePatient(patient);
        return "Patient signed up successfully!";
    }

    // Signin
    @PostMapping("/signin")
    public String signin(@RequestBody Patient patient) {
        try {
            Patient existingPatient = patientService.findByUsername(patient.getUsername());
            if (existingPatient != null && passwordEncoder.matches(patient.getPassword(), existingPatient.getPassword())) {
                return "Patient signed in successfully!";
            } else {
                return "Invalid username or password!";
            }
        } catch (Exception e) {
            return "Signin failed!";
        }
    }
}
