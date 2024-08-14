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

public class SystemicOpiodsRefDTO {

	private long SystemicOpioidsRefID;
	private String SystemicOpiodsDesc;
	
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;

}
