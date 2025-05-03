package com.spring.hospital.controller;

import com.spring.hospital.model.Admin;
import com.spring.hospital.service.AdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Signup endpoint
    @PostMapping("/signup")
    public String signup(@RequestBody Admin admin) {
        if (adminService.existsByUsername(admin.getUsername())) {
            return "Admin with this username already exists!";
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminService.saveAdmin(admin);
        return "Admin signed up successfully!";
    }

    // Signin endpoint
    @PostMapping("/signin")
    public String signin(@RequestBody Admin admin) {
        try {
            Admin existingAdmin = adminService.findByUsername(admin.getUsername());
            if (existingAdmin != null && passwordEncoder.matches(admin.getPassword(), existingAdmin.getPassword())) {
                return "Admin signed in successfully!";
            } else {
                return "Invalid username or password!";
            }
        } catch (Exception e) {
            return "Signin failed!";
        }
    }
}
