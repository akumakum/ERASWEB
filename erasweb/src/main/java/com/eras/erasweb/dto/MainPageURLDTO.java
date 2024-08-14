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

public class MainPageURLDTO {
	private	long	mainPageURLID;
	private long 	hospitalId;
	private	String	hospitalCode;
	private	String	introURL;
	private	String	guideURL;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;
}
