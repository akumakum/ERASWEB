package com.eras.erasweb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Entity
@Table(name = "patient_record")
public class PatientRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long patientID;
    
    private String hospitalCode;
    private String medicalRecordNo;
    private int sequenceNo;
    
    private LocalDate dateofBirth;
    private Gender gender;
    private Estatus eRASStatus;
    
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
    
    @JsonManagedReference
    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comorbidities> comorbidities ;
    
    
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

	@JsonManagedReference
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SystemicOpioids> systemicOpioids;
	    
	
	
	private	SkinToSkin	skinToSkin;
	
	@JsonManagedReference
    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
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
	
	 @JsonManagedReference
	 @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
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
    
   


    public double calculateBMI() {
        this.calculatedBMI = this.weight / (this.height * this.height);
        return this.calculatedBMI;
    }
}
