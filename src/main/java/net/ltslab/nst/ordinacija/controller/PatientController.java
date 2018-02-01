/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;



import net.ltslab.nst.ordinacija.domain.ContactInfo;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.enums.BloodType;
import net.ltslab.nst.ordinacija.domain.enums.Gender;
import net.ltslab.nst.ordinacija.service.PatientService;
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
public class PatientController {

    @Autowired
    PatientService patientService;

    @RequestMapping("/all_patients")
    public String allPatients(Model model) {
        List<Patient> allPatients = patientService.getAllPatient();
        model.addAttribute("patients", allPatients);
        return "/all_patients";
    }
    
    @RequestMapping("/page_patients")
    public String showPagePatients(Model model, 
            @RequestParam(defaultValue="0") int pageNumber, 
            @RequestParam(defaultValue="5") int patientsByPage) {
        Page<Patient> allPatients = patientService.getAllPatientsPaged(pageNumber, patientsByPage);
        model.addAttribute("patients", allPatients);
        model.addAttribute("currentPage", pageNumber);
        return "/page_patients";
    }

    @RequestMapping("/new_patient")
    public String addNewPatient(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("bloodTypes", BloodType.values());
        model.addAttribute("contactInfo", new ContactInfo());
        return "/new_patient";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new_patient")
    public String addNewPatient(@ModelAttribute Patient patient) {
        patient.getContactInfo().setPatient(patient);
        patientService.addOrUpdatePatient(patient);
        return "redirect:/all_patients";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/delete_patient/{id}")
    public String deletePatient(@PathVariable(name="id") Long patientId) {
        patientService.deletePatient(patientId);
        return "redirect:/all_patients";
    }
  

    @RequestMapping("/patient/search")
    public String search(@RequestParam String searchText, Model model) {
        List searchResults = null;
        try {
            searchResults = patientService.searchForPatient(searchText);
        } catch (Exception ex) {
        }
        model.addAttribute("patients", searchResults);
        model.addAttribute("searchedFor", searchText);
        return "search";
    }
}
