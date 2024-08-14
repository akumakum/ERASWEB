package com.eras.erasweb.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.eras.erasweb.model.ComorbiditiesReference;
import com.eras.erasweb.model.PatientRecord;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ComorbiditiesDTO {
	private Long comorbiditiesId;
	private PatientRecord patient;
	private long hospitalCode;
	private long hospitalID;
	private String medicalRecordNo;
	private String comorbidityDesc;
	private long comRefID;
	private ComorbiditiesReference comorbiditiesReference;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private String createdBy;
	private String modifiedBy;
}
