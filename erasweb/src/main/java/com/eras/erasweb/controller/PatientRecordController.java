package com.eras.erasweb.controller;

import com.eras.erasweb.dto.PatientRecordDTO;
import com.eras.erasweb.service.PatientRecordService;
import com.eras.erasweb.model.*;
import com.eras.erasweb.service.ComorbiditiesReferenceService;
import com.eras.erasweb.service.SystemicOpioidsReferenceService;
import com.eras.erasweb.service.OralOpioidsAgentsReferenceService;
import com.eras.erasweb.service.UterotonicAgentReferenceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientRecordController {

	@Autowired
	private PatientRecordService patientRecordService;
	@Autowired
	private ComorbiditiesReferenceService comorbiditiesReferenceService;
	@Autowired
	private SystemicOpioidsReferenceService systemicOpioidsReferenceService;
	@Autowired
	private OralOpioidsAgentsReferenceService oralOpioidsAgentsReferenceService;
	@Autowired
	private UterotonicAgentReferenceService uterotonicAgentReferenceService;

	@GetMapping("/patientrecords")
	public String listPatientRecords(@RequestParam(value = "medicalRecordNo", required = false) String medicalRecordNo,
			@RequestParam(value = "PageNo", defaultValue = "1") int pageNo,
			@RequestParam(value = "PageSize", defaultValue = "5") int pageSize, Model model) {

		Page<PatientRecordDTO> page;

		if (medicalRecordNo != null && !medicalRecordNo.isEmpty()) {
			page = patientRecordService.searchByMedicalRecordNo(medicalRecordNo, PageRequest.of(pageNo - 1, pageSize));
		} else {
			page = patientRecordService.findPaginated(PageRequest.of(pageNo - 1, pageSize));
		}

		model.addAttribute("medicalRecordNo", medicalRecordNo);
		model.addAttribute("records", page.getContent());
		model.addAttribute("currentPage", page.getNumber() + 1);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		return "PaginatedListOfPatientRecords.html";
	}


	@GetMapping("/patientrecords/getpatientrecord")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getPatientRecord(@RequestParam String medicalRecordNo) {
		PatientRecord patientRecord = patientRecordService.getPatientRecordByMrnAndMaxSequenceNumber(medicalRecordNo);
		Map<String, Object> response = new HashMap<>();
		if (patientRecord != null) {
			response.put("status", "found");
			response.put("patientRecord", patientRecord);
			//response.put("dateOfBirth",patientRecord.getDateofBirth());
			// Add other references as needed
		} else {
			response.put("status", "not_found");
			response.put("eRASStatusOptions", Estatus.values());
		}
		return ResponseEntity.ok(response);
	}

}