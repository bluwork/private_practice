/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bobanlukic
 */

@Controller
public class NurseController {
    
    @Autowired
    PatientService patientService;
    
    @RequestMapping("/nurse")
    public String nurse() {
        return "nurse";
    }
    @RequestMapping("/nurse/all_patients")
    public String allPatients(Model model) {
        List<Patient> allPatients = patientService.allPatients();
        model.addAttribute("patients", allPatients);
        return "/nurse/all_patients";
    }
    
    @RequestMapping("/nurse/page_patients")
    public String showPagePatients(Model model, 
            @RequestParam(defaultValue="0") int pageNumber, 
            @RequestParam(defaultValue="5") int patientsByPage) {
        Page<Patient> allPatients = patientService.getAllPatientsPaged(pageNumber, patientsByPage);
        model.addAttribute("patients", allPatients);
        model.addAttribute("currentPage", pageNumber);
        return "/nurse/page_patients";
    }

    @RequestMapping("/nurse/new_patient")
    public String addNewPatient(Model model) {
        model.addAttribute("patient", new PatientDto());
        return "/nurse/new_patient";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/new_patient")
    public String addNewPatient(@ModelAttribute PatientDto patientDto, Model model) {
        Patient p = Converter.convertDtoToEntity(patientDto);
        if (patientService.getPatientById(p.getId()) == null){
            patientService.addOrUpdatePatient(p);
            return "redirect:/nurse/all_patients";
        }
        
        model.addAttribute("patient", patientDto);
        model.addAttribute("patient_id_exists", true);
        
        return "/nurse/new_patient";
        
    }
    @RequestMapping(method = RequestMethod.POST, value = "/nurse/delete_patient/{id}")
    public String deletePatient(@PathVariable(name="id") Long patientId) {
        patientService.deletePatient(patientId);
        return "redirect:/nurse/all_patients";
    }
  

    @RequestMapping("/nurse/search")
    public String search(@RequestParam String searchText, Model model) {
        List searchResults = null;
        try {
            searchResults = patientService.searchForPatient(searchText);
        } catch (Exception ex) {
        }
        model.addAttribute("patients", searchResults);
        model.addAttribute("searchedFor", searchText);
        return "nurse/search";
    }
}
