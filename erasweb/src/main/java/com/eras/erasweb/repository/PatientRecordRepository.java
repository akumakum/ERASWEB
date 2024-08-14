package com.eras.erasweb.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eras.erasweb.model.PatientRecord;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
	
    @Query(value = "SELECT p.dateof_Birth FROM Patient_Record p WHERE p.medical_record_no = :mrn AND p.dateof_birth IS NOT NULL LIMIT 1", nativeQuery = true)
   Optional <LocalDate> findFirstDateOfBirthByMedicalRecordNo(@Param("mrn") String medicalRecordNo);

    Page<PatientRecord> findByMedicalRecordNoContaining(String medicalRecordNo, Pageable pageable);
    Page<PatientRecord> findAll(Pageable pageable);
}
