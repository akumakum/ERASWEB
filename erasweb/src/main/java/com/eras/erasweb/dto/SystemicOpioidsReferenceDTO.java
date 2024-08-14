package com.eras.erasweb.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SystemicOpioidsReferenceDTO {
    
    private Long systemicOpioidsRefId;
    
    private String systemicOpioidsDesc;
    
    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private String createdBy;

    private String modifiedBy;
}
