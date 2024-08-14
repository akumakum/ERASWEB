package com.eras.erasweb.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.eras.erasweb.model.ASASCORE;
import com.eras.erasweb.model.AnaesthesiaType;
import com.eras.erasweb.model.AntibioticProphylaxis;
import com.eras.erasweb.model.Comorbidities;
import com.eras.erasweb.model.Day300Followup;
import com.eras.erasweb.model.Estatus;
import com.eras.erasweb.model.EstatusYorN;
import com.eras.erasweb.model.Gender;
import com.eras.erasweb.model.ITMUsed;
import com.eras.erasweb.model.InHospitalComplications;
import com.eras.erasweb.model.OralOpioids;
import com.eras.erasweb.model.OralOpioidsAgents;
import com.eras.erasweb.model.PONVProphylaxis;
import com.eras.erasweb.model.PONVProphylaxisAgents;
import com.eras.erasweb.model.PROMToolUsed;
import com.eras.erasweb.model.PROMneeded;
import com.eras.erasweb.model.PostDischargeComplications;
import com.eras.erasweb.model.PreopEducation;
import com.eras.erasweb.model.Readmision;
import com.eras.erasweb.model.Recatheterised;
import com.eras.erasweb.model.RegularNSAIDS;
import com.eras.erasweb.model.RegularParacetamol;
import com.eras.erasweb.model.SkinToSkin;
import com.eras.erasweb.model.SystemicOpioids;
import com.eras.erasweb.model.SystemicOpioidsUsed;
import com.eras.erasweb.model.TrialofVoid;
import com.eras.erasweb.model.UterotonicAgent;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PatientRecordDTO {

	    private long patientID;
	    
	    private String hospitalCode;
	    private String medicalRecordNo;
	    private LocalDate dateofBirth;
	    private Gender gender;
	    private Estatus eRASStatus;
	    private int sequenceNo;
	    
	    private LocalDate admissionDate;
	    private LocalTime admissionTime;
	    private int age;
	    private double height;
	    private double weight;
	    
	    private double calculatedBMI; // Calculated Method
	    
	    private String surgicalSpecialty;
	    private String surgicalType;
	    
	    private EstatusYorN eRASStatusYN;
	    private ASASCORE aSAScore;
	    
	
	    private List<Comorbidities> comorbidities;
	    
	    
	    private	PreopEducation	preopEducation;
		private	LocalDate	preopLastFluidsDate;
		private	LocalTime	preopLasFluidsTime;
		private	double	preopFastingStatusFluids;
		private	LocalDate	preopLastSolidsDate;
		private	LocalTime	preopLastSolidsTime;
		private	double	preopFastingStatusSolids;
		private	AntibioticProphylaxis	antibioticProphylaxis;
		private	PONVProphylaxis	pONVProphylaxis;
		private	PONVProphylaxisAgents	pONVProphylaxisAgents;
		private	AnaesthesiaType	anaesthesiaType;
		private	ITMUsed	iTMUsed;
		private	SystemicOpioidsUsed	systemicOpioidsUsed;

		private List<SystemicOpioids> systemicOpioids;
		    
		
		
		private	SkinToSkin	skinToSkin;
		
	
	    private List<UterotonicAgent> uterotonicAgent;
	    
		
		private	LocalDate	postOpOralFluidIntakeDate;
		private	LocalTime	postOpOralFluidIntakeTime;
		private	double	timetoOralFluidIntake;
		private	LocalDate	postOpOralSolidsIntakeDate;
		private	LocalTime	PostOpOralSolidsIntakeTime;
		private	double		timetoOralSolidsIntake;
		private	LocalDate	mobilisationStartDate;
		private	LocalTime	mobilisationStartTime;
		private	double	timetoMobilisationFromSurgery;
		private	LocalDate	removalUrinaryCatheterDate;
		private	LocalTime	removalUrinaryCatheterTime;
		
		private	TrialofVoid	trialofVoid;
		private	Recatheterised	recatheterised;
		private	RegularParacetamol	regularParacetamol;
		private	RegularNSAIDS	regularNSAIDS;
		private	OralOpioids	oralOpioids;
		
	
		 private List<OralOpioidsAgents> oralOpioidsAgents;	
		
		
		private	LocalDate	firstDoseOralOpioidsDate	;
		private	LocalTime	firstDoseOralOpioidsTime	;
		private	double	totalOralOpioids	;
		private	double	totalIVFluidsGivenml	;
		private	LocalDate	dischargeDate	;
		private	LocalTime	dischargeTime	;

		private	double	durationOfStayHrs;
		private	double	lengthOfStayNights;
				
		private	InHospitalComplications	inHospitalComplications;
		private	String	inHospitalComplicationsnotes;
				
		private	Day300Followup	day300Followup;
		private	PostDischargeComplications	postDischargeComplications;
		private	String	postDischargeComplicationsnotes;
		
		private	Readmision	readmision	;
		private	String	ReadmisionNotes	;
					
		private	PROMneeded	pROMneeded	;
		private	PROMToolUsed	pROMToolUsed	;
		private	double	pROmResults	;
		private	Boolean	IsInactive	;
		@UpdateTimestamp
	    @Column(name = "date_created", nullable = false, updatable = false)
	    private LocalDateTime dateCreated;

	    @UpdateTimestamp
	    private LocalDateTime dateUpdated;

	    private String createdBy;
	    private String modifiedBy;
	    
	    @Column( nullable = true, updatable = false)
	    private long complianceCount;




}
