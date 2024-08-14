package com.eras.erasweb.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.eras.erasweb.model.GenericPosition;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class UserDTO {

    private long UserID;
    @NotEmpty(message="User ID should not be empty")
    @Size(max = 10, message = "User ID too long, Please comply with Maximum lenght of  10 Characters")
	private String UserDefinedID;
    private String emailAdd;
    @NotEmpty(message="FullName should not be empty")
    private String fullName;
    @NotEmpty(message="Password should not be empty")
    private String password;
    @Transient
    @NotEmpty(message="Confirm Password should not be empty")
    private String confirmPassword;
    private String salt;
    private long userTypeID;
    private String position;
    private String hospitalCode;
    private long hospitalId;
    private Boolean isInactive;
    private String userTypeDesc;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;
}