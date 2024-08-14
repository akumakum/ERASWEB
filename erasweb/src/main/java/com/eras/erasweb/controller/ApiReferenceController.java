package com.eras.erasweb.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eras.erasweb.service.ComorbiditiesReferenceService;
import com.eras.erasweb.service.SystemicOpioidsReferenceService;
import com.eras.erasweb.service.UterotonicAgentReferenceService;
import com.eras.erasweb.service.OralOpioidsAgentsReferenceService;
import com.eras.erasweb.service.PatientRecordService;
import com.eras.erasweb.model.*;

@RestController
public class ApiReferenceController {

 
	public ApiReferenceController(ComorbiditiesReferenceService comorbiditiesReferenceService,
			SystemicOpioidsReferenceService systemicOpioidsReferenceService,
			UterotonicAgentReferenceService uterotonicAgentReferenceService,
			OralOpioidsAgentsReferenceService oralOpioidsAgentsReferenceService,
			PatientRecordService patientRecordService) {
		super();
		this.comorbiditiesReferenceService = comorbiditiesReferenceService;
		this.systemicOpioidsReferenceService = systemicOpioidsReferenceService;
		this.uterotonicAgentReferenceService = uterotonicAgentReferenceService;
		this.oralOpioidsAgentsReferenceService = oralOpioidsAgentsReferenceService;
		this.patientRecordService=patientRecordService;
	}

	@Autowired
    private ComorbiditiesReferenceService comorbiditiesReferenceService;
	@Autowired
    private SystemicOpioidsReferenceService systemicOpioidsReferenceService;
	@Autowired
	private UterotonicAgentReferenceService uterotonicAgentReferenceService;
	@Autowired
	private OralOpioidsAgentsReferenceService oralOpioidsAgentsReferenceService ;
	@Autowired
	private PatientRecordService patientRecordService;
	

    @GetMapping("/ajax/comorbiditiesref/all")
    public List<ComorbiditiesReference> getAllComorbidities() {
    
    	return comorbiditiesReferenceService.findAll();
    }
    
    @GetMapping("/ajax/systemicOpioidsRef/all")
    public List<SystemicOpioidsReference> getAllSystemicOpioidsReference() {
    	return systemicOpioidsReferenceService.findAll();
    }
    
    
    @GetMapping("/ajax/uterotonicAgentRef/all")
    public List<UterotonicAgentReference> getAllUterotonicAgentReference(){
    	return uterotonicAgentReferenceService.findAll();
    }
    
    @GetMapping("/ajax/oralOpioidsAgentsRef/all")
    public List<OralOpioidsAgentsReference> getAlOralOpiodReferenceAgentReference(){
    	return oralOpioidsAgentsReferenceService.findAll();
    }
   
    @GetMapping("/ajax/get-date-of-birth")
    public ResponseEntity<LocalDate> getDateOfBirth(@RequestParam String medicalRecordNo) {
        Optional<LocalDate> dateOfBirth = patientRecordService.getDateOfBirthByMedicalRecordNo(medicalRecordNo);
        return dateOfBirth.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}
