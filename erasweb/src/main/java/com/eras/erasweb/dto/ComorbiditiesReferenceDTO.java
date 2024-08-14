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
public class ComorbiditiesReferenceDTO {
    
    private Long commorbidityId;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String createdBy;
    private String modifiedBy;
}


//package com.eras.erasweb.dto;
//
//import java.time.LocalDateTime;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class ComorbiditiesReferenceDTO {
//    
//    private long commorbidityId;
//    private String description;
//    private LocalDateTime dateCreated;
//    private LocalDateTime dateUpdated;
//    private String createdBy;
//    private String modifiedBy;
//}
