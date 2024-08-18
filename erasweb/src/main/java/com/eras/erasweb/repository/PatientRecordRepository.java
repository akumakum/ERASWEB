package com.eras.erasweb.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eras.erasweb.model.PatientRecord;

import jakarta.transaction.Transactional;

import com.eras.erasweb.model.*;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
	
    @Query(value = "SELECT p.dateof_Birth FROM Patient_Record p WHERE p.medical_record_no = :mrn AND p.dateof_birth IS NOT NULL LIMIT 1", nativeQuery = true)
   Optional <LocalDate> findFirstDateOfBirthByMedicalRecordNo(@Param("mrn") String medicalRecordNo);

    Page<PatientRecord> findByMedicalRecordNoContaining(String medicalRecordNo, Pageable pageable);
    Page<PatientRecord> findAll(Pageable pageable);
    
    @Query("SELECT pr FROM PatientRecord pr WHERE pr.medicalRecordNo = :mrn AND pr.sequenceNo = (SELECT MAX(pr2.sequenceNo) FROM PatientRecord pr2 WHERE pr2.medicalRecordNo = :mrn)")
    PatientRecord findByMrnAndMaxSequenceNumber(@Param("mrn") String mrn);
    
    @Modifying
    @Transactional
    @Query("UPDATE PatientRecord p SET p.hospitalCode = :hospitalCode, p.medicalRecordNo = :medicalRecordNo, p.sequenceNo = :sequenceNo, " +
            "p.dateofBirth = :dateofBirth, p.gender = :gender, p.eRASStatus = :eRASStatus, p.admissionDate = :admissionDate, " +
            "p.admissionTime = :admissionTime, p.age = :age, p.height = :height, p.weight = :weight, p.calculatedBMI = :calculatedBMI, " +
            "p.surgicalSpecialty = :surgicalSpecialty, p.surgicalType = :surgicalType, p.eRASStatusYN = :eRASStatusYN, p.aSAScore = :aSAScore, " +
            "p.preopEducation = :preopEducation, p.preopLastFluidsDate = :preopLastFluidsDate, p.preopLasFluidsTime = :preopLasFluidsTime, " +
            "p.preopFastingStatusFluids = :preopFastingStatusFluids, p.preopLastSolidsDate = :preopLastSolidsDate, p.preopLastSolidsTime = :preopLastSolidsTime, " +
            "p.preopFastingStatusSolids = :preopFastingStatusSolids, p.antibioticProphylaxis = :antibioticProphylaxis, p.pONVProphylaxis = :pONVProphylaxis, " +
            "p.pONVProphylaxisAgents = :pONVProphylaxisAgents, p.anaesthesiaType = :anaesthesiaType, p.iTMUsed = :iTMUsed, " +
            "p.systemicOpioidsUsed = :systemicOpioidsUsed, p.skinToSkin = :skinToSkin, p.postOpOralFluidIntakeDate = :postOpOralFluidIntakeDate, " +
            "p.postOpOralFluidIntakeTime = :postOpOralFluidIntakeTime, p.timetoOralFluidIntake = :timetoOralFluidIntake, p.postOpOralSolidsIntakeDate = :postOpOralSolidsIntakeDate, " +
            "p.PostOpOralSolidsIntakeTime = :PostOpOralSolidsIntakeTime, p.timetoOralSolidsIntake = :timetoOralSolidsIntake, p.mobilisationStartDate = :mobilisationStartDate, " +
            "p.mobilisationStartTime = :mobilisationStartTime, p.timetoMobilisationFromSurgery = :timetoMobilisationFromSurgery, p.removalUrinaryCatheterDate = :removalUrinaryCatheterDate, " +
            "p.removalUrinaryCatheterTime = :removalUrinaryCatheterTime, p.trialofVoid = :trialofVoid, p.recatheterised = :recatheterised, " +
            "p.regularParacetamol = :regularParacetamol, p.regularNSAIDS = :regularNSAIDS, p.oralOpioids = :oralOpioids, p.firstDoseOralOpioidsDate = :firstDoseOralOpioidsDate, " +
            "p.firstDoseOralOpioidsTime = :firstDoseOralOpioidsTime, p.totalOralOpioids = :totalOralOpioids, p.totalIVFluidsGivenml = :totalIVFluidsGivenml, " +
            "p.dischargeDate = :dischargeDate, p.dischargeTime = :dischargeTime, p.durationOfStayHrs = :durationOfStayHrs, p.lengthOfStayNights = :lengthOfStayNights, " +
            "p.inHospitalComplications = :inHospitalComplications, p.inHospitalComplicationsnotes = :inHospitalComplicationsnotes, p.day300Followup = :day300Followup, " +
            "p.postDischargeComplications = :postDischargeComplications, p.postDischargeComplicationsnotes = :postDischargeComplicationsnotes, p.readmision = :readmision, " +
            "p.ReadmisionNotes = :ReadmisionNotes, p.pROMneeded = :pROMneeded, p.pROMToolUsed = :pROMToolUsed, p.pROmResults = :pROmResults, " +
            "p.IsInactive = :IsInactive, p.modifiedBy = :modifiedBy WHERE p.patientID = :patientID")
    void updatePatientRecord(
            @Param("patientID") long patientID,
            @Param("hospitalCode") String hospitalCode,
            @Param("medicalRecordNo") String medicalRecordNo,
            @Param("sequenceNo") int sequenceNo,
            @Param("dateofBirth") LocalDate dateofBirth,
            @Param("gender") Gender gender,
            @Param("eRASStatus") Estatus eRASStatus,
            @Param("admissionDate") LocalDate admissionDate,
            @Param("admissionTime") LocalTime admissionTime,
            @Param("age") int age,
            @Param("height") double height,
            @Param("weight") double weight,
            @Param("calculatedBMI") double calculatedBMI,
            @Param("surgicalSpecialty") String surgicalSpecialty,
            @Param("surgicalType") String surgicalType,
            @Param("eRASStatusYN") EstatusYorN eRASStatusYN,
            @Param("aSAScore") ASASCORE aSAScore,
            @Param("preopEducation") PreopEducation preopEducation,
            @Param("preopLastFluidsDate") LocalDate preopLastFluidsDate,
            @Param("preopLasFluidsTime") LocalTime preopLasFluidsTime,
            @Param("preopFastingStatusFluids") double preopFastingStatusFluids,
            @Param("preopLastSolidsDate") LocalDate preopLastSolidsDate,
            @Param("preopLastSolidsTime") LocalTime preopLastSolidsTime,
            @Param("preopFastingStatusSolids") double preopFastingStatusSolids,
            @Param("antibioticProphylaxis") AntibioticProphylaxis antibioticProphylaxis,
            @Param("pONVProphylaxis") PONVProphylaxis pONVProphylaxis,
            @Param("pONVProphylaxisAgents") PONVProphylaxisAgents pONVProphylaxisAgents,
            @Param("anaesthesiaType") AnaesthesiaType anaesthesiaType,
            @Param("iTMUsed") ITMUsed iTMUsed,
            @Param("systemicOpioidsUsed") SystemicOpioidsUsed systemicOpioidsUsed,
            @Param("skinToSkin") SkinToSkin skinToSkin,
            @Param("postOpOralFluidIntakeDate") LocalDate postOpOralFluidIntakeDate,
            @Param("postOpOralFluidIntakeTime") LocalTime postOpOralFluidIntakeTime,
            @Param("timetoOralFluidIntake") double timetoOralFluidIntake,
            @Param("postOpOralSolidsIntakeDate") LocalDate postOpOralSolidsIntakeDate,
            @Param("PostOpOralSolidsIntakeTime") LocalTime PostOpOralSolidsIntakeTime,
            @Param("timetoOralSolidsIntake") double timetoOralSolidsIntake,
            @Param("mobilisationStartDate") LocalDate mobilisationStartDate,
            @Param("mobilisationStartTime") LocalTime mobilisationStartTime,
            @Param("timetoMobilisationFromSurgery") double timetoMobilisationFromSurgery,
            @Param("removalUrinaryCatheterDate") LocalDate removalUrinaryCatheterDate,
            @Param("removalUrinaryCatheterTime") LocalTime removalUrinaryCatheterTime,
            @Param("trialofVoid") TrialofVoid trialofVoid,
            @Param("recatheterised") Recatheterised recatheterised,
            @Param("regularParacetamol") RegularParacetamol regularParacetamol,
            @Param("regularNSAIDS") RegularNSAIDS regularNSAIDS,
            @Param("oralOpioids") OralOpioids oralOpioids,
            @Param("firstDoseOralOpioidsDate") LocalDate firstDoseOralOpioidsDate,
            @Param("firstDoseOralOpioidsTime") LocalTime firstDoseOralOpioidsTime,
            @Param("totalOralOpioids") double totalOralOpioids,
            @Param("totalIVFluidsGivenml") double totalIVFluidsGivenml,
            @Param("dischargeDate") LocalDate dischargeDate,
            @Param("dischargeTime") LocalTime dischargeTime,
            @Param("durationOfStayHrs") double durationOfStayHrs,
            @Param("lengthOfStayNights") double lengthOfStayNights,
            @Param("inHospitalComplications") InHospitalComplications inHospitalComplications,
            @Param("inHospitalComplicationsnotes") String inHospitalComplicationsnotes,
            @Param("day300Followup") Day300Followup day300Followup,
            @Param("postDischargeComplications") PostDischargeComplications postDischargeComplications,
            @Param("postDischargeComplicationsnotes") String postDischargeComplicationsnotes,
            @Param("readmision") Readmision readmision,
            @Param("ReadmisionNotes") String ReadmisionNotes,
            @Param("pROMneeded") PROMneeded pROMneeded,
            @Param("pROMToolUsed") PROMToolUsed pROMToolUsed,
            @Param("pROmResults") double pROmResults,
            @Param("IsInactive") Boolean IsInactive,
            @Param("modifiedBy") String modifiedBy);
}


