package com.eras.erasweb.utils;

import com.eras.erasweb.model.*;
import com.eras.erasweb.dto.*;

public class ModelToDtoDtoToModel {
	
	public static UserTypeDTO convertToUserTypeDTO(UserType userType) {
	    UserTypeDTO userTypeDTO = new UserTypeDTO();
	    userTypeDTO.setUserTypeID(userType.getUserTypeID());
	    userTypeDTO.setUserTypeDesc(userType.getUserTypeDesc());
	    userTypeDTO.setUserTypeCode(userType.getUserTypeCode());
	    userTypeDTO.setDateCreated(userType.getDateCreated());
	    userTypeDTO.setDateUpdated(userType.getDateUpdated());
	    userTypeDTO.setCreatedBy(userType.getCreatedBy());
	    userTypeDTO.setModifiedBy(userType.getModifiedBy());
	    return userTypeDTO;
	}

	public static UserPositionDTO convertToUserPositionDTO(UserPosition userPosition) {
	    UserPositionDTO userPositionDTO = new UserPositionDTO();
	    userPositionDTO.setUserPositionID(userPosition.getUserPositionID());
	    userPositionDTO.setUserPostionDesc(userPosition.getUserPostionDesc());
	    userPositionDTO.setDateCreated(userPosition.getDateCreated());
	    userPositionDTO.setDateUpdated(userPosition.getDateUpdated());
	    userPositionDTO.setCreatedBy(userPosition.getCreatedBy());
	    userPositionDTO.setModifiedBy(userPosition.getModifiedBy());
	    return userPositionDTO;
	}

	public UserDTO mapToUser(User user) {
		return UserDTO.builder().userID(user.getUserID()).userDefinedID(user.getUserDefinedID())
				.emailAdd(user.getEmailAdd()).fullName(user.getFullName()).password(user.getPassword())
				.salt(user.getSalt()).userTypeID(user.getUserTypeID())
				.hospitalCode(user.getHospitalCode()).hospitalId(user.getHospitalId()).isInactive(user.getIsInactive())
				.dateCreated(user.getDateCreated()).dateUpdated(user.getDateUpdated()).createdBy(user.getCreatedBy())
				.modifiedBy(user.getModifiedBy())
				.userTypeDesc(user.getUserTypeDesc())
				.build();
	}
	
	public User mapToUserDTO(UserDTO user) {
		return User.builder().UserID(user.getUserID()).UserDefinedID(user.getUserDefinedID())
				.emailAdd(user.getEmailAdd()).fullName(user.getFullName()).password(user.getPassword())
				.salt(user.getSalt()).userTypeID(user.getUserTypeID())
				.hospitalCode(user.getHospitalCode()).hospitalId(user.getHospitalId()).isInactive(user.getIsInactive())
				.dateCreated(user.getDateCreated())
				.dateUpdated(user.getDateUpdated())
				.createdBy(user.getCreatedBy())
				.modifiedBy(user.getModifiedBy())
				.userTypeDesc(user.getUserTypeDesc())
				.build();
	}

	
	public HospitalDTO mapToHospital(Hospital hospital) {
		 return HospitalDTO.builder()
				 .hospitalCode(hospital.getHospitalCode())
				 .HospitalName(hospital.getHospitalName())
				 .address1(hospital.getAddress1())
				 .address2(hospital.getAddress2())
				 .address3(hospital.getAddress3())
				 .address4(hospital.getAddress4())
				 .country(hospital.getCountry())
				 .contactName(hospital.getContactName())
				 .contactPhone(hospital.getContactPhone())
				 .dateCreated(hospital.getDateCreated())
				 .createdBy(hospital.getCreatedBy())
				 .dateUpdated(hospital.getDateUpdated())
				 .modifiedBy(hospital.getModifiedBy())
				 .emailAddress(hospital.getEmailAddress())
				 .build();
				 
	}
	
	public Hospital mapToHospitalDTO(HospitalDTO hospital) {
		 return Hospital.builder()
				 .hospitalCode(hospital.getHospitalCode())
				 .hospitalName(hospital.getHospitalName())
				 .address1(hospital.getAddress1())
				 .address2(hospital.getAddress2())
				 .address3(hospital.getAddress3())
				 .address4(hospital.getAddress4())
				 .country(hospital.getCountry())
				 .contactName(hospital.getContactName())
				 .contactPhone(hospital.getContactPhone())
				 .dateCreated(hospital.getDateCreated())
				 .createdBy(hospital.getCreatedBy())
				 .dateUpdated(hospital.getDateUpdated())
				 .modifiedBy(hospital.getModifiedBy())
				 .emailAddress(hospital.getEmailAddress())
				 .build();
				 
	}
	
	
	public MainPageURL mapToMainPageURLDTO(MainPageURLDTO mainPageURL) {
		 return MainPageURL.builder()
				 .mainPageURLID(mainPageURL.getMainPageURLID())
		 		 .hospitalId(mainPageURL.getHospitalId())
				 .hospitalCode(mainPageURL.getHospitalCode())
				 .guideURL(mainPageURL.getGuideURL())
				 .introURL(mainPageURL.getIntroURL())
				 .createdBy(mainPageURL.getCreatedBy())
				 .dateCreated(mainPageURL.getDateCreated())
				 .modifiedBy(mainPageURL.getModifiedBy())
				 .dateUpdated(mainPageURL.getDateUpdated())
				 .build();
	}
	
	public MainPageURLDTO mapToMainPageURL(MainPageURL mainPageURL) {
		 return MainPageURLDTO.builder()
				 .mainPageURLID(mainPageURL.getMainPageURLID())
		 		 .hospitalId(mainPageURL.getHospitalId())
				 .hospitalCode(mainPageURL.getHospitalCode())
				 .guideURL(mainPageURL.getGuideURL())
				 .introURL(mainPageURL.getIntroURL())
				 .createdBy(mainPageURL.getCreatedBy())
				 .dateCreated(mainPageURL.getDateCreated())
				 .modifiedBy(mainPageURL.getModifiedBy())
				 .dateUpdated(mainPageURL.getDateUpdated())
				 .build();
	}
	
	

	
	public UserPositionDTO mapToUserPositionDTO(UserPosition userPosition) {
		return UserPositionDTO.builder()
				.UserPositionID(userPosition.getUserPositionID())
				.UserPostionDesc(userPosition.getUserPostionDesc())
				.dateCreated(userPosition.getDateCreated())
				.dateUpdated(userPosition.getDateUpdated())
				.createdBy(userPosition.getCreatedBy())
				.modifiedBy(userPosition.getModifiedBy()).build();
			
	}

	
	
	public UserPosition mapToUserPosition(UserPositionDTO userPosition) {
		return UserPosition.builder()
				.userPositionID(userPosition.getUserPositionID())
				.userPostionDesc(userPosition.getUserPostionDesc())
				.dateCreated(userPosition.getDateCreated())
				.dateUpdated(userPosition.getDateUpdated())
				.createdBy(userPosition.getCreatedBy())
				.modifiedBy(userPosition.getModifiedBy())
				.build();
				
	}
	

	public UserType mapToUserType(UserTypeDTO userType) {
		return UserType.builder().userTypeID(userType.getUserTypeID()).userTypeDesc(userType.getUserTypeDesc())
				.userTypeCode(userType.getUserTypeCode()).createdBy(userType.getCreatedBy())
				.dateCreated(userType.getDateCreated()).modifiedBy(userType.getModifiedBy())
				.dateUpdated(userType.getDateUpdated()).build();

	}
	
	
	public UserTypeDTO mapToUserTypeDTO(UserType userType) {
		return UserTypeDTO.builder().userTypeID(userType.getUserTypeID()).userTypeDesc(userType.getUserTypeDesc())
				.userTypeCode(userType.getUserTypeCode()).createdBy(userType.getCreatedBy())
				.dateCreated(userType.getDateCreated()).modifiedBy(userType.getModifiedBy())
				.dateUpdated(userType.getDateUpdated()).build();

	}

   public PatientRecordDTO mapToPatientRecordDTO(PatientRecord patientRecord) {
	   return PatientRecordDTO.builder()
			   .patientID(patientRecord.getPatientID())
			   .hospitalCode(patientRecord.getHospitalCode())
			   .medicalRecordNo(patientRecord.getMedicalRecordNo())
			   .dateofBirth(patientRecord.getDateofBirth())
			   .gender(patientRecord.getGender())
			   .eRASStatus(patientRecord.getERASStatus())
			   .admissionDate(patientRecord.getAdmissionDate())
			   .admissionTime(patientRecord.getAdmissionTime())
			   .age(patientRecord.getAge())
			   .height(patientRecord.getHeight())
			   .weight(patientRecord.getWeight())
			   .calculatedBMI(patientRecord.getCalculatedBMI())
			   .surgicalSpecialty(patientRecord.getSurgicalSpecialty())
			   .surgicalType(patientRecord.getSurgicalType())
			   .eRASStatusYN(patientRecord.getERASStatusYN())
			   .aSAScore(patientRecord.getASAScore())
			   .comorbidities(patientRecord.getComorbidities())
			   .preopEducation(patientRecord.getPreopEducation())
			   .preopLastFluidsDate(patientRecord.getPreopLastFluidsDate())
			   .preopLasFluidsTime(patientRecord.getPreopLasFluidsTime())
			   .preopFastingStatusFluids(patientRecord.getPreopFastingStatusFluids())
			   .preopLastSolidsDate(patientRecord.getPreopLastSolidsDate())
			   .preopLastSolidsTime(patientRecord.getPreopLastSolidsTime())
			   .preopFastingStatusSolids(patientRecord.getPreopFastingStatusSolids())
			   .antibioticProphylaxis(patientRecord.getAntibioticProphylaxis())
			   .pONVProphylaxis(patientRecord.getPONVProphylaxis())
			   .pONVProphylaxisAgents(patientRecord.getPONVProphylaxisAgents())
			   .anaesthesiaType(patientRecord.getAnaesthesiaType())
			   .iTMUsed(patientRecord.getITMUsed())
			   .systemicOpioidsUsed(patientRecord.getSystemicOpioidsUsed())
			   .systemicOpioids(patientRecord.getSystemicOpioids())
			   .skinToSkin(patientRecord.getSkinToSkin())
			   .uterotonicAgent(patientRecord.getUterotonicAgent())
			   .postOpOralFluidIntakeDate(patientRecord.getPostOpOralFluidIntakeDate())
			   .postOpOralFluidIntakeTime(patientRecord.getPostOpOralFluidIntakeTime())
			   .timetoOralFluidIntake(patientRecord.getTimetoOralFluidIntake())
			   .postOpOralSolidsIntakeDate(patientRecord.getPostOpOralSolidsIntakeDate())
			   .PostOpOralSolidsIntakeTime(patientRecord.getPostOpOralSolidsIntakeTime())
			   .timetoOralSolidsIntake(patientRecord.getTimetoOralSolidsIntake())
			   .mobilisationStartDate(patientRecord.getMobilisationStartDate())
			   .mobilisationStartTime(patientRecord.getMobilisationStartTime())
			   .timetoMobilisationFromSurgery(patientRecord.getTimetoMobilisationFromSurgery())
			   .removalUrinaryCatheterDate(patientRecord.getRemovalUrinaryCatheterDate())
			   .removalUrinaryCatheterTime(patientRecord.getRemovalUrinaryCatheterTime())
			   .trialofVoid(patientRecord.getTrialofVoid())
			   .recatheterised(patientRecord.getRecatheterised())
			   .regularParacetamol(patientRecord.getRegularParacetamol())
			   .regularNSAIDS(patientRecord.getRegularNSAIDS())
			   .oralOpioids(patientRecord.getOralOpioids())
			   .oralOpioidsAgents(patientRecord.getOralOpioidsAgents())
			   .firstDoseOralOpioidsDate(patientRecord.getFirstDoseOralOpioidsDate())
			   .firstDoseOralOpioidsTime(patientRecord.getFirstDoseOralOpioidsTime())
			   .totalOralOpioids(patientRecord.getTotalOralOpioids())
			   .totalIVFluidsGivenml(patientRecord.getTotalIVFluidsGivenml())
			   .dischargeDate(patientRecord.getDischargeDate())
			   .dischargeTime(patientRecord.getDischargeTime())
			   .durationOfStayHrs(patientRecord.getDurationOfStayHrs())
			   .lengthOfStayNights(patientRecord.getLengthOfStayNights())
			   .inHospitalComplications(patientRecord.getInHospitalComplications())
			   .inHospitalComplicationsnotes(patientRecord.getInHospitalComplicationsnotes())
			   .day300Followup(patientRecord.getDay300Followup())
			   .postDischargeComplications(patientRecord.getPostDischargeComplications())
			   .postDischargeComplicationsnotes(patientRecord.getPostDischargeComplicationsnotes())
			   .readmision(patientRecord.getReadmision())
			   .ReadmisionNotes(patientRecord.getReadmisionNotes())
			   .pROMneeded(patientRecord.getPROMneeded())
			   .pROMToolUsed(patientRecord.getPROMToolUsed())
			   .pROmResults(patientRecord.getPROmResults())
			   .IsInactive(patientRecord.getIsInactive())
			   .dateCreated(patientRecord.getDateCreated())
			   .dateUpdated(patientRecord.getDateUpdated())
			   .createdBy(patientRecord.getCreatedBy())
			   .modifiedBy(patientRecord.getModifiedBy())
			   .complianceCount(patientRecord.getComplianceCount())
			   .build();
   }
   public PatientRecord mapToPatientRecord(PatientRecordDTO patientRecord) {
	   return PatientRecord.builder()
			   .patientID(patientRecord.getPatientID())
			   .hospitalCode(patientRecord.getHospitalCode())
			   .medicalRecordNo(patientRecord.getMedicalRecordNo())
			   .dateofBirth(patientRecord.getDateofBirth())
			   .gender(patientRecord.getGender())
			   .eRASStatus(patientRecord.getERASStatus())
			   .admissionDate(patientRecord.getAdmissionDate())
			   .admissionTime(patientRecord.getAdmissionTime())
			   .age(patientRecord.getAge())
			   .height(patientRecord.getHeight())
			   .weight(patientRecord.getWeight())
			   .calculatedBMI(patientRecord.getCalculatedBMI())
			   .surgicalSpecialty(patientRecord.getSurgicalSpecialty())
			   .surgicalType(patientRecord.getSurgicalType())
			   .eRASStatusYN(patientRecord.getERASStatusYN())
			   .aSAScore(patientRecord.getASAScore())
			   .comorbidities(patientRecord.getComorbidities())
			   .preopEducation(patientRecord.getPreopEducation())
			   .preopLastFluidsDate(patientRecord.getPreopLastFluidsDate())
			   .preopLasFluidsTime(patientRecord.getPreopLasFluidsTime())
			   .preopFastingStatusFluids(patientRecord.getPreopFastingStatusFluids())
			   .preopLastSolidsDate(patientRecord.getPreopLastSolidsDate())
			   .preopLastSolidsTime(patientRecord.getPreopLastSolidsTime())
			   .preopFastingStatusSolids(patientRecord.getPreopFastingStatusSolids())
			   .antibioticProphylaxis(patientRecord.getAntibioticProphylaxis())
			   .pONVProphylaxis(patientRecord.getPONVProphylaxis())
			   .pONVProphylaxisAgents(patientRecord.getPONVProphylaxisAgents())
			   .anaesthesiaType(patientRecord.getAnaesthesiaType())
			   .iTMUsed(patientRecord.getITMUsed())
			   .systemicOpioidsUsed(patientRecord.getSystemicOpioidsUsed())
			   .systemicOpioids(patientRecord.getSystemicOpioids())
			   .skinToSkin(patientRecord.getSkinToSkin())
			   .uterotonicAgent(patientRecord.getUterotonicAgent())
			   .postOpOralFluidIntakeDate(patientRecord.getPostOpOralFluidIntakeDate())
			   .postOpOralFluidIntakeTime(patientRecord.getPostOpOralFluidIntakeTime())
	
			   .timetoOralFluidIntake(patientRecord.getTimetoOralFluidIntake())
			   
			   .postOpOralSolidsIntakeDate(patientRecord.getPostOpOralSolidsIntakeDate())
			   .PostOpOralSolidsIntakeTime(patientRecord.getPostOpOralSolidsIntakeTime())
			
			   .timetoOralSolidsIntake(patientRecord.getTimetoOralSolidsIntake())
			   
			   .mobilisationStartDate(patientRecord.getMobilisationStartDate())
			   .mobilisationStartTime(patientRecord.getMobilisationStartTime())
			   .timetoMobilisationFromSurgery(patientRecord.getTimetoMobilisationFromSurgery())
			   .removalUrinaryCatheterDate(patientRecord.getRemovalUrinaryCatheterDate())
			   .removalUrinaryCatheterTime(patientRecord.getRemovalUrinaryCatheterTime())
			   .trialofVoid(patientRecord.getTrialofVoid())
			   .recatheterised(patientRecord.getRecatheterised())
			   .regularParacetamol(patientRecord.getRegularParacetamol())
			   .regularNSAIDS(patientRecord.getRegularNSAIDS())
			   .oralOpioids(patientRecord.getOralOpioids())
			   .oralOpioidsAgents(patientRecord.getOralOpioidsAgents())
			   .firstDoseOralOpioidsDate(patientRecord.getFirstDoseOralOpioidsDate())
			   .firstDoseOralOpioidsTime(patientRecord.getFirstDoseOralOpioidsTime())
			   .totalOralOpioids(patientRecord.getTotalOralOpioids())
			   .totalIVFluidsGivenml(patientRecord.getTotalIVFluidsGivenml())
			   .dischargeDate(patientRecord.getDischargeDate())
			   .dischargeTime(patientRecord.getDischargeTime())
			   .durationOfStayHrs(patientRecord.getDurationOfStayHrs())
			   .lengthOfStayNights(patientRecord.getLengthOfStayNights())
			   .inHospitalComplications(patientRecord.getInHospitalComplications())
			   .inHospitalComplicationsnotes(patientRecord.getInHospitalComplicationsnotes())
			   .day300Followup(patientRecord.getDay300Followup())
			   .postDischargeComplications(patientRecord.getPostDischargeComplications())
			   .postDischargeComplicationsnotes(patientRecord.getPostDischargeComplicationsnotes())
			   .readmision(patientRecord.getReadmision())
			   .ReadmisionNotes(patientRecord.getReadmisionNotes())
			   .pROMneeded(patientRecord.getPROMneeded())
			   .pROMToolUsed(patientRecord.getPROMToolUsed())
			   .pROmResults(patientRecord.getPROmResults())
			   .IsInactive(patientRecord.getIsInactive())
			   .dateCreated(patientRecord.getDateCreated())
			   .dateUpdated(patientRecord.getDateUpdated())
			   .createdBy(patientRecord.getCreatedBy())
			   .modifiedBy(patientRecord.getModifiedBy())
			   .complianceCount(patientRecord.getComplianceCount())
			   .build();
   }
   
   public ComorbiditiesReferenceDTO ComorbiditiesReferencetoDTO(ComorbiditiesReference entity) {
	   return ComorbiditiesReferenceDTO.builder()
	           .commorbidityId(entity.getCommorbidityId())
	           .description(entity.getDescription())
	           .dateCreated(entity.getDateCreated())
	           .dateUpdated(entity.getDateUpdated())
	           .createdBy(entity.getCreatedBy())
	           .modifiedBy(entity.getModifiedBy())
	           .build();
	  }

	  public  ComorbiditiesReference ComorbiditiesReferencetoEntity(ComorbiditiesReferenceDTO dto) {
	   return ComorbiditiesReference.builder()
	           .commorbidityId(dto.getCommorbidityId())
	           .description(dto.getDescription())
	           .dateCreated(dto.getDateCreated())
	           .dateUpdated(dto.getDateUpdated())
	           .createdBy(dto.getCreatedBy())
	           .modifiedBy(dto.getModifiedBy())
	           .build();
	  }

}
