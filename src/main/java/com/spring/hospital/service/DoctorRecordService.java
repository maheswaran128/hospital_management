package com.spring.hospital.service;

import com.spring.hospital.model.DoctorRecord;
import com.spring.hospital.repository.DoctorRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorRecordService {

    @Autowired
    private DoctorRecordRepository doctorRecordRepository;

    public DoctorRecord createDoctor(DoctorRecord doctorRecord) {
        return doctorRecordRepository.save(doctorRecord);
    }

    public List<DoctorRecord> getAllDoctors() {
        return doctorRecordRepository.findAll();
    }

    public DoctorRecord getDoctorById(Long id) {
        Optional<DoctorRecord> doctorRecord = doctorRecordRepository.findById(id);
        return doctorRecord.orElse(null);
    }

    public DoctorRecord updateDoctor(Long id, DoctorRecord doctorRecord) {
        if (doctorRecordRepository.existsById(id)) {
            doctorRecord.setId(id);
            return doctorRecordRepository.save(doctorRecord);
        }
        return null;
    }

    public void deleteDoctor(Long id) {
        doctorRecordRepository.deleteById(id);
    }
}
