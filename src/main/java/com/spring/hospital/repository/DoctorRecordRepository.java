package com.spring.hospital.repository;

import com.spring.hospital.model.DoctorRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRecordRepository extends JpaRepository<DoctorRecord, Long> {
}
