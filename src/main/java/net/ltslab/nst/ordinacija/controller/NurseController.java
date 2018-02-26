/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.time.LocalDate;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;

/**
 *
 * @author bobanlukic
 */
@Controller
public class NurseController {

    @Autowired
    OrdinacijaFacade ordinacijaFacade;

    @RequestMapping("/nurse")
    public String nurse() {
        return "nurse";
    }

    @RequestMapping("/nurse/show_patients")
    public String allPatients(Model model) {

        model.addAttribute("patients", ordinacijaFacade.getAllPatients());

        return "/nurse/show_patients";
    }

    @RequestMapping("/nurse/page_patients")
    public String showPagePatients(Model model,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "5") int patientsByPage) {

        model.addAttribute("patients", ordinacijaFacade.getAllPatients(pageNumber, patientsByPage));
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

        if (ordinacijaFacade.addPatient(patientDto)) {
            return "redirect:/nurse/show_patients";
        }

        model.addAttribute("patient", patientDto);
        model.addAttribute("patient_id_exists", true);

        return "/nurse/new_patient";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/delete_patient/{id}")
    public String deletePatient(@PathVariable(name = "id") Long patientId) {

        ordinacijaFacade.deletePatient(patientId);
        return "redirect:/nurse/show_patients";
    }

    @RequestMapping("/nurse/search")
    public String search(@RequestParam String searchText, Model model) {

        model.addAttribute("patients", ordinacijaFacade.searchFor(searchText));
        model.addAttribute("searchedFor", searchText);

        return "nurse/show_patients";
    }

    @RequestMapping("/nurse/schedule_medical/{id}")
    public String scheduleMedical(@PathVariable(name = "id") Long patientId, Model model) {

        model.addAttribute("patient", ordinacijaFacade.getPatient(patientId));
        model.addAttribute("doctors", ordinacijaFacade.getAllActiveDoctors());

        return "/nurse/schedule_medical";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/schedule_medical")
    public String scheduleMedical(@ModelAttribute Medical medical) {

        return "redirect:/nurse";
    }

    @RequestMapping("/nurse/add_vitals/{id}")
    public String addVitals(@PathVariable(name = "id") Long patientId, Model model) {

        model.addAttribute("vitals", ordinacijaFacade.getVitalsFor(patientId));
        return "/nurse/add_vitals";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/add_vitals")
    public String postVitals(@ModelAttribute Vitals vitals) {

        ordinacijaFacade.saveVitals(vitals);

        return "redirect:/nurse/show_patients";
    }

    @RequestMapping("/nurse/scheduled_today")
    public String scheduledPatients(Model model) {
        model.addAttribute("patients", ordinacijaFacade.getScheduledPatients(LocalDate.now()));
        return "/nurse/scheduled_today";
    }
}
