package com.eras.erasweb.service;

import com.eras.erasweb.dto.ComorbiditiesDTO;
import com.eras.erasweb.dto.PatientRecordDTO;
import com.eras.erasweb.model.PatientRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PatientRecordService {
    List<PatientRecord> findAll();
    PatientRecord findById(Long id);
    PatientRecord save(PatientRecord patientRecord);
    void deleteById(Long id);
    public Optional<LocalDate> getDateOfBirthByMedicalRecordNo(String medicalRecordNo);
    Page<PatientRecordDTO> searchByMedicalRecordNo(String medicalRecordNo, Pageable pageable);
    Page<PatientRecordDTO> findPaginated(Pageable pageable);
    
 // Method to get the PatientRecord with the maximum sequence number for a given MRN
    public PatientRecord getPatientRecordByMrnAndMaxSequenceNumber(String mrn);
    
    void updatePatientRecord(PatientRecord patientRecord);
    
    PatientRecord saveNewPatientRecord(PatientRecord patientRecord);
  
}                                               
