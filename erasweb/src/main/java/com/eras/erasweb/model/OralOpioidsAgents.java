package com.eras.erasweb.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "oral_opioids_agents")
public class OralOpioidsAgents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oralOpioidsAgentsId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patientRecord_id")
    private PatientRecord patient;

    @ManyToOne
    @JoinColumn(name = "oral_opioids_agents_ref_id")
    private OralOpioidsAgentsReference oralOpioidsAgentsReference;
    
    private String oralOpioidsAgentsDesc;
    
    private long hospitalCode;
    private long hospitalID;
    private String medicalRecordNo;

    private Long comRefID;
    @Builder.Default
    private long dosage=0;

    @UpdateTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    private String createdBy;
    private String modifiedBy;
}
