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
import java.util.UUID;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "users", uniqueConstraints={
        @UniqueConstraint(columnNames = {"fullName"})
})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserID;
    
    @ManyToOne
    @JoinColumn(name = "user_position_id")
    private UserPosition userPositions;
    
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userTypes;
   
    @Column(unique=true,length=10)
	private String UserDefinedID;
    @Column(unique=true, length=80)
    private String emailAdd;
    @Column(unique=true,length= 100)
    private String fullName;
    private String password;
    private String salt;
    private long userTypeID;
    private String userTypeDesc;
    private String position;
    private String hospitalCode;
    private long hospitalId;
    @Builder.Default 
    private Boolean isInactive=false;
 
    @Column(name= "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;
    private String confirmPassword;
    
}