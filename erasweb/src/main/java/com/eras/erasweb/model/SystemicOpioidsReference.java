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
@Table(name = "systemic_opioids_reference")
public class SystemicOpioidsReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemicOpioidsRefId;
    
    @Column(unique = true, length = 100)
    private String systemicOpioidsDesc;
    
    @UpdateTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    private String createdBy;
    private String modifiedBy;
}
