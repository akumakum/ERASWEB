package com.eras.erasweb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eras.erasweb.service.SystemicOpioidsReferenceService;

import com.eras.erasweb.utils.SystemicOpioidsReferenceConverter;

import com.eras.erasweb.dto.*;
import com.eras.erasweb.model.SystemicOpioidsReference;


import java.util.List;

@Controller
@RequestMapping("/patientrecords/systemic-opioidsreference")
public class SystemicOpioidsReferenceController {

    @Autowired
    private SystemicOpioidsReferenceService systemicOpioidsReferenceService;

    @GetMapping
    public String list(Model model) {
    	List<SystemicOpioidsReference> list = systemicOpioidsReferenceService.findAll();
    	 List<SystemicOpioidsReferenceDTO> dtoList = SystemicOpioidsReferenceConverter.entityListToDtoList(list);
         model.addAttribute("systemicOpioidsReference", dtoList);
        return "ListOfsystemicOpiodsReference";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("systemicOpioidsReference", new SystemicOpioidsReferenceDTO());
        return "SystemicOpiodsReference-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SystemicOpioidsReferenceDTO dto, RedirectAttributes redirectAttributes) {
        
    	systemicOpioidsReferenceService.save(dto);
        redirectAttributes.addFlashAttribute("message", "systemic Opioids Agents Reference saved successfully.");
        return "redirect:/patientrecords/systemic-opioidsreference";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        SystemicOpioidsReference entity =  systemicOpioidsReferenceService.findById(id);
        SystemicOpioidsReferenceDTO dto = SystemicOpioidsReferenceConverter.entityToDto(entity);   //.toDto(entity);
        model.addAttribute("systemicOpioidsReference", dto);
        return "systemicOpiodsReference-create";
    }

  
}
