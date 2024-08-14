package com.eras.erasweb.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

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

public class SystemicOpiodsDTO {

	    private Long systemicOpioidsId;

	    private long hospitalCode;
	    private long hospitalID;
	    private String medicalRecordNo;
	    private String systemicOpioidsDesc;
	    private long dosage;
	    


	    @UpdateTimestamp
	    @Column(name = "date_created", nullable = false, updatable = false)
	    private LocalDateTime dateCreated;

	    @UpdateTimestamp
	    private LocalDateTime dateUpdated;

	    private String createdBy;
	    private String modifiedBy;
	}


