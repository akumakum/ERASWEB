package com.eras.erasweb.controller;



import com.eras.erasweb.dto.ComorbiditiesReferenceDTO;
import com.eras.erasweb.service.ComorbiditiesReferenceServiceMaint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/maintenance/comorbiditiesreference")
public class ComorbiditiesReferenceController {

    @Autowired
    private ComorbiditiesReferenceServiceMaint comorbiditiesReferenceService;

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("comorbiditiesReference", new ComorbiditiesReferenceDTO());
        return "CommorbidityReference-create";
    }
    
    @GetMapping("/list")
    public String listComorbiditiesReferences(Model model) {
        List<ComorbiditiesReferenceDTO> references = comorbiditiesReferenceService.getAllReferences();
        model.addAttribute("comorbiditiesReferences", references);
        return "ListOfCommorbiditiesReference";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        ComorbiditiesReferenceDTO comorbiditiesReferenceDTO = comorbiditiesReferenceService.getReferenceById(id);
        model.addAttribute("comorbiditiesReference", comorbiditiesReferenceDTO);
        return "CommorbidityReference-edit";
    }

    @PostMapping("/update")
    public String updateComorbiditiesReference(@Valid @ModelAttribute("comorbiditiesReference") ComorbiditiesReferenceDTO comorbiditiesReferenceDTO,
                                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "CommorbidityReference-create";
        }

        try {
            comorbiditiesReferenceService.updateReference(comorbiditiesReferenceDTO); // UpdateReference(comorbiditiesReferenceDTO);
            return "redirect:/maintenance/comorbiditiesreference/list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while updating the comorbidity reference. Please try again.");
            
            return "CommorbidityReference-create";
        }
    }

    @PostMapping("/save")
    public String saveComorbiditiesReference(@Valid @ModelAttribute("comorbiditiesReference") ComorbiditiesReferenceDTO comorbiditiesReferenceDTO,
                                             BindingResult result, Model model) {
       if (result.hasErrors()) {
            return "ListOfCommorbiditiesReference";
        }

        try {
            comorbiditiesReferenceService.createOrUpdateReference(comorbiditiesReferenceDTO);
            return "redirect:/maintenance/comorbiditiesreference/list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", result.getFieldError());
            
            return "CommorbidityReference-create";
        }

       
    }}