/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/add_new_patient")
    public String addNewPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "/add_new_patient";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new_patient")
    public void addNewPatient(@ModelAttribute Patient patient) {
        patientService.addOrUpdatePatient(patient);
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
