package com.eras.erasweb.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;

public class AuditClass {
	    @Column(name= "date_created", nullable = false, updatable = false)
	    private LocalDateTime dateCreated;
	    @UpdateTimestamp
	    private LocalDateTime dateUpdated;
	    private String createdBy;
	    private String modifiedBy;
}
