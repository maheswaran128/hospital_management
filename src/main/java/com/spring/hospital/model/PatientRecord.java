package com.spring.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PatientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId; // This links to the logged-in patient (could also be fetched from user context)

    private String fullName;
    private String gender;
    private LocalDate dateOfBirth;
    private String contactNumber;
    private String emailAddress;
    private String address;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String bloodGroup;
    private String allergies;
    private String chronicConditions; // comma-separated list
    private String currentMedications;
    private String doctorAssigned;
    private String diagnosisReasonForVisit;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String emergencyContactName) { this.emergencyContactName = emergencyContactName; }

    public String getEmergencyContactNumber() { return emergencyContactNumber; }
    public void setEmergencyContactNumber(String emergencyContactNumber) { this.emergencyContactNumber = emergencyContactNumber; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getChronicConditions() { return chronicConditions; }
    public void setChronicConditions(String chronicConditions) { this.chronicConditions = chronicConditions; }

    public String getCurrentMedications() { return currentMedications; }
    public void setCurrentMedications(String currentMedications) { this.currentMedications = currentMedications; }

    public String getDoctorAssigned() { return doctorAssigned; }
    public void setDoctorAssigned(String doctorAssigned) { this.doctorAssigned = doctorAssigned; }

    public String getDiagnosisReasonForVisit() { return diagnosisReasonForVisit; }
    public void setDiagnosisReasonForVisit(String diagnosisReasonForVisit) { this.diagnosisReasonForVisit = diagnosisReasonForVisit; }
}
