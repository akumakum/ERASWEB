package com.eras.erasweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eras.erasweb.service.SystemicOpioidsReferenceService;
import com.eras.erasweb.service.UterotonicAgentReferenceService;
import com.eras.erasweb.utils.SystemicOpioidsReferenceConverter;
import com.eras.erasweb.utils.UterotonicAgentReferenceConverter;
import com.eras.erasweb.dto.*;
import com.eras.erasweb.model.SystemicOpioidsReference;
import com.eras.erasweb.model.UterotonicAgentReference;

import java.util.List;

@Controller
@RequestMapping("/patientrecords/uterotonicAgentReference")
public class UterotonicAgentReferenceController {

    @Autowired
    private UterotonicAgentReferenceService uterotonicAgentReferenceService;

    @GetMapping
    public String list(Model model) {
    	List<UterotonicAgentReference> list = uterotonicAgentReferenceService.findAll();
    	 List<UterotonicAgentReferenceDTO> agent = UterotonicAgentReferenceConverter.entitiesToDtos(list); 
    	//dtoList.get(0).getUterotonicAgentRefId();
        
    	 model.addAttribute("uterotonicAgentReference", agent);
        return "ListOfUretonicAgentReference";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("uterotonicAgentReference", new UterotonicAgentReferenceDTO());
        return "UterotonicAgentReference-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UterotonicAgentReferenceDTO dto, RedirectAttributes redirectAttributes) {
    	uterotonicAgentReferenceService.save(dto);
    	
        redirectAttributes.addFlashAttribute("message", "systemic Opioids Agents Reference saved successfully.");
        return "redirect:/patientrecords/uterotonicAgentReference";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        UterotonicAgentReference entity =  uterotonicAgentReferenceService.findById(id);
        UterotonicAgentReferenceDTO dto = UterotonicAgentReferenceConverter.entityToDto(entity);   //.toDto(entity);
        model.addAttribute("uterotonicAgentReference", dto);
        return "UterotonicAgentReference-create";
    }

  
}
