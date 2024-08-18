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
@Table(name = "uterotonic_agent")
public class UterotonicAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uterotonicAgentId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patientRecord_id")
    private PatientRecord patient;

    @ManyToOne
    @JoinColumn(name = "uterotonic_agent_ref_id")
    private UterotonicAgentReference uterotonicAgentReference;
    
    
    @UpdateTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;
    
    private String MedicalRecordNo;
    private Long comRefID;
                 

    private String uterotonicAgentDescription;
    
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    private String createdBy;
    private String modifiedBy;
}
