package com.eras.erasweb.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.eras.erasweb.model.GenericPosition;
import com.eras.erasweb.model.UserPosition;
import com.eras.erasweb.model.UserType;

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

	private long userID;
	 @NotEmpty(message="User ID should not be empty")
	    private String userDefinedID;
	    private String emailAdd;
		@NotEmpty(message="FullName should not be empty")
	    private String fullName;
		private String password;
		private String userTypeDesc;
		@Transient
	    @NotEmpty(message="Confirm Password should not be empty")
	    private String confirmPassword;
		private String salt;
	    private String hospitalCode;
	    private long hospitalId;
	    private Boolean isInactive;
	    private LocalDateTime dateCreated;
	    private LocalDateTime dateUpdated;
	    private String createdBy;
	    private String modifiedBy;
	    private UserTypeDTO userTypes;
	    private UserPositionDTO userPositions;
	    private long userTypeID;
	    private long userPositionID;
}