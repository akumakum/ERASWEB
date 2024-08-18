package com.eras.erasweb.service.impl;



import com.eras.erasweb.dto.ComorbiditiesDTO;
import com.eras.erasweb.dto.PatientRecordDTO;
import com.eras.erasweb.model.PatientRecord;
import com.eras.erasweb.repository.PatientRecordRepository;
import com.eras.erasweb.service.PatientRecordService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientRecordServiceImpl implements PatientRecordService {

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    public PatientRecordServiceImpl(PatientRecordRepository patientRecordRepository) {
		super();
		this.patientRecordRepository = patientRecordRepository;
	}

	@Override
    public List<PatientRecord> findAll() {
        return patientRecordRepository.findAll();
    }

    @Override
    public PatientRecord findById(Long id) {
        return patientRecordRepository.findById(id).orElse(null);
    }

  
    @Override
    public PatientRecord save(PatientRecord patientRecord) {
    	
    	
    	return patientRecordRepository.save(patientRecord);
    }

    @Override
    public void deleteById(Long id) {
        patientRecordRepository.deleteById(id);
    }

	@Override
	public Optional<LocalDate> getDateOfBirthByMedicalRecordNo(String medicalRecordNo) {
        return patientRecordRepository.findFirstDateOfBirthByMedicalRecordNo(medicalRecordNo);
    }
	
	
    public Page<PatientRecordDTO> searchByMedicalRecordNo(String medicalRecordNo, Pageable pageable) {
        Page<PatientRecord> patientRecords = patientRecordRepository.findByMedicalRecordNoContaining(medicalRecordNo, pageable);
        return patientRecords.map(this::mapToDTO);
    }

    private PatientRecordDTO mapToDTO(PatientRecord patientRecord) {
        return PatientRecordDTO.builder()
                .patientID(patientRecord.getPatientID())
                .medicalRecordNo(patientRecord.getMedicalRecordNo())
                .sequenceNo(patientRecord.getSequenceNo())
                .dateCreated(patientRecord.getDateCreated())
                .createdBy(patientRecord.getCreatedBy())
                .dateUpdated(patientRecord.getDateUpdated())
                .modifiedBy(patientRecord.getModifiedBy())
                .build();
    }
    
    @Override
    public Page<PatientRecordDTO> findPaginated(Pageable pageable) {
        Page<PatientRecord> patientRecords = patientRecordRepository.findAll(pageable);
        return patientRecords.map(this::mapToDTO);
    }

	@Override
	public PatientRecord getPatientRecordByMrnAndMaxSequenceNumber(String mrn) {
		// Method to get the PatientRecord with the maximum sequence number for a given MRN
		PatientRecord tmprepo;
		tmprepo= patientRecordRepository.findByMrnAndMaxSequenceNumber(mrn);
	        return patientRecordRepository.findByMrnAndMaxSequenceNumber(mrn);
	    }
	
	@Transactional
    public void updatePatientRecord(PatientRecord patientRecord) {
        patientRecord.calculateBMI(); // Ensure BMI is calculated before saving
        patientRecordRepository.updatePatientRecord(
                patientRecord.getPatientID(),
                patientRecord.getHospitalCode(),
                patientRecord.getMedicalRecordNo(),
                patientRecord.getSequenceNo(),
                patientRecord.getDateofBirth(),
                patientRecord.getGender(),
                patientRecord.getERASStatus(),
                patientRecord.getAdmissionDate(),
                patientRecord.getAdmissionTime(),
                patientRecord.getAge(),
                patientRecord.getHeight(),
                patientRecord.getWeight(),
                patientRecord.getCalculatedBMI(),
                patientRecord.getSurgicalSpecialty(),
                patientRecord.getSurgicalType(),
                patientRecord.getERASStatusYN(),
                patientRecord.getASAScore(),
                patientRecord.getPreopEducation(),
                patientRecord.getPreopLastFluidsDate(),
                patientRecord.getPreopLasFluidsTime(),
                patientRecord.getPreopFastingStatusFluids(),
                patientRecord.getPreopLastSolidsDate(),
                patientRecord.getPreopLastSolidsTime(),
                patientRecord.getPreopFastingStatusSolids(),
                patientRecord.getAntibioticProphylaxis(),
                patientRecord.getPONVProphylaxis(),
                patientRecord.getPONVProphylaxisAgents(),
                patientRecord.getAnaesthesiaType(),
                patientRecord.getITMUsed(),
                patientRecord.getSystemicOpioidsUsed(),
                patientRecord.getSkinToSkin(),
                patientRecord.getPostOpOralFluidIntakeDate(),
                patientRecord.getPostOpOralFluidIntakeTime(),
                patientRecord.getTimetoOralFluidIntake(),
                patientRecord.getPostOpOralSolidsIntakeDate(),
                patientRecord.getPostOpOralSolidsIntakeTime(),
                patientRecord.getTimetoOralSolidsIntake(),
                patientRecord.getMobilisationStartDate(),
                patientRecord.getMobilisationStartTime(),
                patientRecord.getTimetoMobilisationFromSurgery(),
                patientRecord.getRemovalUrinaryCatheterDate(),
                patientRecord.getRemovalUrinaryCatheterTime(),
                patientRecord.getTrialofVoid(),
                patientRecord.getRecatheterised(),
                patientRecord.getRegularParacetamol(),
                patientRecord.getRegularNSAIDS(),
                patientRecord.getOralOpioids(),
                patientRecord.getFirstDoseOralOpioidsDate(),
                patientRecord.getFirstDoseOralOpioidsTime(),
                patientRecord.getTotalOralOpioids(),
                patientRecord.getTotalIVFluidsGivenml(),
                patientRecord.getDischargeDate(),
                patientRecord.getDischargeTime(),
                patientRecord.getDurationOfStayHrs(),
                patientRecord.getLengthOfStayNights(),
                patientRecord.getInHospitalComplications(),
                patientRecord.getInHospitalComplicationsnotes(),
                patientRecord.getDay300Followup(),
                patientRecord.getPostDischargeComplications(),
                patientRecord.getPostDischargeComplicationsnotes(),
                patientRecord.getReadmision(),
                patientRecord.getReadmisionNotes(),
                patientRecord.getPROMneeded(),
                patientRecord.getPROMToolUsed(),
                patientRecord.getPROmResults(),
                patientRecord.getIsInactive(),
                patientRecord.getModifiedBy()
        );
    }
	
}

	

