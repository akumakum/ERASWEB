package com.eras.erasweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HospitalDTO {

	private long hospitalID;
	@NotEmpty(message="User ID should not be empty")
	private String hospitalCode;
	@NotEmpty(message="Hospital Code should not be empty")
	private String HospitalName;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String country;
	private String contactName;
	private String contactPhone;
	private String emailAddress;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private String createdBy;
	private String modifiedBy;

}
