package com.eras.erasweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class MainPageURL {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long	mainPageURLID	;
	@Column(unique=true, length=10)
	private	String	hospitalCode;
	private long 	hospitalId;
	private	String	introURL;
	private	String	guideURL;
	
    @Column(name= "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;

}
