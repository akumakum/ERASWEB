package com.eras.erasweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "oral_opioids_agents_reference")
public class OralOpioidsAgentsReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oralOpioidsAgentsRefId;
              
    private String oralOpioidsAgentsRefDesc;

    @UpdateTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    private String createdBy;
    private String modifiedBy;
}
