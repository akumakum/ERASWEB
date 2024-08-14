package com.eras.erasweb.controller;

import com.eras.erasweb.dto.PatientRecordDTO;
import com.eras.erasweb.service.PatientRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientRecordController {

	   @Autowired
	    private PatientRecordService patientRecordService;

	    @GetMapping("/patientrecords/patientrecords")
	    public String listPatientRecords(
	            @RequestParam(value = "medicalRecordNo", required = false) String medicalRecordNo,
	            @RequestParam(value = "PageNo", defaultValue = "1") int pageNo,
	            @RequestParam(value = "PageSize", defaultValue = "5") int pageSize,
	            Model model) {

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
}