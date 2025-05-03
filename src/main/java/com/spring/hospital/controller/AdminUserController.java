package com.spring.hospital.controller;

import com.spring.hospital.model.AdminUser;
import com.spring.hospital.model.PatientRecord;
import com.spring.hospital.model.DoctorRecord;
import com.spring.hospital.service.AdminUserService;
import com.spring.hospital.service.PatientRecordService;
import com.spring.hospital.service.DoctorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private PatientRecordService patientRecordService;

    @Autowired
    private DoctorRecordService doctorRecordService;

    // -------------------- Admin User Operations --------------------

    @PostMapping("/users/add")
    public AdminUser addAdmin(@RequestBody AdminUser adminUser) {
        return adminUserService.addAdmin(adminUser);
    }

    @GetMapping("/users")
    public List<AdminUser> getAllAdmins() {
        return adminUserService.getAllAdmins();
    }

    @GetMapping("/users/{id}")
    public AdminUser getAdminById(@PathVariable Long id) {
        return adminUserService.getAdminById(id);
    }

    @PutMapping("/users/{id}")
    public AdminUser updateAdmin(@PathVariable Long id, @RequestBody AdminUser adminUser) {
        return adminUserService.updateAdmin(id, adminUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminUserService.deleteAdmin(id);
    }

    // -------------------- Patient Record Operations --------------------

    @GetMapping("/patients")
    public List<PatientRecord> getAllPatientRecords() {
        return patientRecordService.getAllRecords();
    }

    @GetMapping("/patients/{id}")
    public PatientRecord getPatientRecord(@PathVariable Long id) {
        return patientRecordService.getRecordById(id);
    }

    @PostMapping("/patients/add")
    public PatientRecord addPatientRecord(@RequestBody PatientRecord record) {
        return patientRecordService.addRecord(record);
    }

    @PutMapping("/patients/{id}")
    public PatientRecord updatePatientRecord(@PathVariable Long id, @RequestBody PatientRecord record) {
        return patientRecordService.updateRecord(id, record);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatientRecord(@PathVariable Long id) {
        patientRecordService.deleteRecord(id);
    }

    // -------------------- Doctor Record Operations --------------------

    @PostMapping("/doctors/add")
    public DoctorRecord addDoctor(@RequestBody DoctorRecord doctorRecord) {
        return doctorRecordService.createDoctor(doctorRecord);
    }

    @GetMapping("/doctors")
    public List<DoctorRecord> getAllDoctors() {
        return doctorRecordService.getAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    public DoctorRecord getDoctorById(@PathVariable Long id) {
        return doctorRecordService.getDoctorById(id);
    }

    @PutMapping("/doctors/{id}")
    public DoctorRecord updateDoctor(@PathVariable Long id, @RequestBody DoctorRecord doctorRecord) {
        return doctorRecordService.updateDoctor(id, doctorRecord);
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRecordService.deleteDoctor(id);
    }
}
