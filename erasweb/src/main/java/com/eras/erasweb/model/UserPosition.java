package com.eras.erasweb.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class UserPosition {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserPositionID;
	@Column(unique=true,length=15)
	private String UserPostionDesc;
	
    @Column(name= "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;
   // @UpdateTimestamp
    @Column(nullable = true, updatable = true)
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;

}
