/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bobanlukic
 */
@Controller
public class DoctorController {

    @Autowired
    OrdinacijaFacade ordinacijaFacade;

    @RequestMapping("/doctor")
    public String doctorPage(HttpServletRequest request, Model model) {

        model.addAttribute("doctor", ordinacijaFacade.getDoctor(request));
        model.addAttribute("patients", ordinacijaFacade.getScheduledPatients(request));

        return "/doctor";
    }

    @RequestMapping("/doctor/medical/{id}")
    public String medical(HttpServletRequest request, @PathVariable(name = "id") Long patientId, Model model) {

        model.addAttribute("medical", ordinacijaFacade.getMedicalDto(request, patientId));
        return "/doctor/medical";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/doctor/new_medical")
    public String postMedical(@ModelAttribute MedicalDto medical) {

        ordinacijaFacade.save(medical);
        return "redirect:/doctor";
    }

}
