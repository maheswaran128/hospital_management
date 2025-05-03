package com.spring.hospital.controller;

import com.spring.hospital.model.DoctorRecord;
import com.spring.hospital.service.DoctorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRecordController {

    @Autowired
    private DoctorRecordService doctorRecordService;

    @PostMapping
    public ResponseEntity<DoctorRecord> createDoctor(@RequestBody DoctorRecord doctorRecord) {
        DoctorRecord createdDoctor = doctorRecordService.createDoctor(doctorRecord);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DoctorRecord>> getAllDoctors() {
        List<DoctorRecord> doctors = doctorRecordService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorRecord> getDoctorById(@PathVariable Long id) {
        DoctorRecord doctor = doctorRecordService.getDoctorById(id);
        return doctor != null ? new ResponseEntity<>(doctor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorRecord> updateDoctor(@PathVariable Long id, @RequestBody DoctorRecord doctorRecord) {
        DoctorRecord updatedDoctor = doctorRecordService.updateDoctor(id, doctorRecord);
        return updatedDoctor != null ? new ResponseEntity<>(updatedDoctor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorRecordService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
