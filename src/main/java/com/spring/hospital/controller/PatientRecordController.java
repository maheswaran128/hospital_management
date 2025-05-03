package com.spring.hospital.controller;

import com.spring.hospital.model.PatientRecord;
import com.spring.hospital.service.PatientRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient/records")
public class PatientRecordController {

    private final PatientRecordService service;

    public PatientRecordController(PatientRecordService service) {
        this.service = service;
    }

    @GetMapping("/{patientId}")
    public List<PatientRecord> getRecords(@PathVariable Long patientId) {
        return service.getRecordsByPatientId(patientId);
    }

    @PostMapping("/add")
    public PatientRecord addRecord(@RequestBody PatientRecord record) {
        return service.addRecord(record);
    }

    @PutMapping("/{id}")
    public PatientRecord updateRecord(@PathVariable Long id, @RequestBody PatientRecord updatedRecord) {
        return service.updateRecord(id, updatedRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}
