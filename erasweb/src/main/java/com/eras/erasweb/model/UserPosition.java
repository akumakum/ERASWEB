package com.eras.erasweb.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Column(name="user_position_id")
	private long userPositionID;
	@Column(unique=true,length=15)
	private String userPostionDesc;
	
	@OneToMany(mappedBy = "userPositions")
    private List<User> users = new ArrayList<>();
	
    @Column(name= "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;
   // @UpdateTimestamp
    @Column(nullable = true, updatable = true)
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;

}
