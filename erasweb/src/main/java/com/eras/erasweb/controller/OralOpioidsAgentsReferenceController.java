package com.eras.erasweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eras.erasweb.service.OralOpioidsAgentsReferenceService;
import com.eras.erasweb.utils.OralOpioidsAgentsReferenceConverter;
import com.eras.erasweb.dto.*;
import com.eras.erasweb.model.OralOpioidsAgentsReference;

import java.util.List;

@Controller
@RequestMapping("/maintenance/oral-opioidsreference")
public class OralOpioidsAgentsReferenceController {

    @Autowired
    private OralOpioidsAgentsReferenceService oralOpioidsAgentsReferenceService;

    @GetMapping
    public String list(Model model) {
        List<OralOpioidsAgentsReferenceDTO> list = oralOpioidsAgentsReferenceService.findAlldto();
        model.addAttribute("oralOpioidsAgentsReference", list);
        return "ListOfOralOpiodsAgentReference";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("oralOpioidsAgentsReference", new OralOpioidsAgentsReferenceDTO());
        return "OralOpiodsReference-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute OralOpioidsAgentsReferenceDTO dto, RedirectAttributes redirectAttributes) {
        
    	oralOpioidsAgentsReferenceService.save(dto);
        redirectAttributes.addFlashAttribute("message", "Oral Opioids Agents Reference saved successfully.");
        return "redirect:/maintenance/oral-opioidsreference";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        OralOpioidsAgentsReference entity =  oralOpioidsAgentsReferenceService.findById(id);
        OralOpioidsAgentsReferenceDTO dto =OralOpioidsAgentsReferenceConverter.toDto(entity);
        model.addAttribute("oralOpioidsAgentsReference", dto);
        return "OralOpiodsReference-create";
    }

  
}
