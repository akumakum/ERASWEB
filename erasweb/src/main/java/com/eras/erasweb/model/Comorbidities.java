package com.eras.erasweb.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Entity
@Table(name = "comorbidities")
public class Comorbidities {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comorbiditiesId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patientRecord_id")
    private PatientRecord patient;
    
    private String hospitalCode;
    private long hospitalID;
    private String medicalRecordNo;
    private String comorbidityDesc;
    
    private Long comRefID;
    
    
 @ManyToOne
 @JoinColumn(name = "comorbidities_ref_id")
   private ComorbiditiesReference comorbiditiesReference;
    @UpdateTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

  
    private LocalDateTime dateUpdated;

    private String createdBy;
    private String modifiedBy;
}
