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
public class UserType {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userTypeID;
	@Column(unique=true, length=15)
	private String userTypeDesc;
	private int userTypeCode;
	@Column(name= "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;
 //   @UpdateTimestamp
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;
	

}
