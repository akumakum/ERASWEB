package com.eras.erasweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class CommorbidityRef {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commorbidityId;
	@Column(unique=true, length=100)
	private String commorbidityDesc;
	
    @Column(name= "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;

}
