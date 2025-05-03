package com.spring.hospital.service;

import com.spring.hospital.model.Doctor;
import com.spring.hospital.repository.DoctorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@Service
public class DoctorService implements UserDetailsService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // For Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByUsername(username);
        if (doctor == null) {
            throw new UsernameNotFoundException("Doctor not found with username: " + username);
        }

        return new User(doctor.getUsername(), doctor.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_DOCTOR")));
    }

    // Custom methods for Controller usage
    public boolean existsByUsername(String username) {
        return doctorRepository.existsByUsername(username);  // Check if username exists
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);  // Save new doctor
    }

    public Doctor findByUsername(String username) {
        return doctorRepository.findByUsername(username);  // Find doctor by username
    }
}
