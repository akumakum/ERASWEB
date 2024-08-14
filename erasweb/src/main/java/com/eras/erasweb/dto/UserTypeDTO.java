package com.eras.erasweb.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class UserTypeDTO {

	private long userTypeID;
	private String userTypeDesc;
	private int userTypeCode;
	
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;
	

}
