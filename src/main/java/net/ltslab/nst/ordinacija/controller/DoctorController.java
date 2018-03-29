/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import net.ltslab.nst.ordinacija.jms.PrescriptionSender;
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

    //TEMPORARY - Blu
    @Autowired
    PrescriptionSender prescriptionSender;

    @RequestMapping("/doctor")
    public String doctorPage(HttpServletRequest request, Model model) {

        model.addAttribute("doctor", ordinacijaFacade.getDoctor(request));
        model.addAttribute("patients", ordinacijaFacade.getScheduledPatients(request));

        return "/doctor";
    }

    @RequestMapping(value = "/doctor/medical/{id}")
    public String medical(HttpServletRequest request, @PathVariable(name = "id") String patientId, Model model) {
          
        model.addAttribute("medical", ordinacijaFacade.getMedicalDto(request, patientId));
        model.addAttribute("diagnoses", ordinacijaFacade.getDiagnoses());

        return "/doctor/medical";

    }
    @RequestMapping(value = "/doctor/medical")
    public String medicalRedirect() {

        return "/doctor/medical";

    }

//    @RequestMapping(method= RequestMethod.POST, value = "/doctor/medical", params = {"addPrescription"})
//    public String addPrescription(@ModelAttribute MedicalDto medical, RedirectAttributes ra) {
//        medical.getPrescriptions().add(new PrescriptionDto());
//        ra.addFlashAttribute("medical", medical);
//        return "redirect:/doctor/medical";
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/doctor/medical", params = {"removePrescription"})
//    public String removePrescription(
//            @ModelAttribute MedicalDto medical, final BindingResult bindingResult,
//            final HttpServletRequest req) {
//        final Integer rowId = Integer.valueOf(req.getParameter("removePrescription"));
//        medical.getPrescriptions().remove(rowId.intValue());
//        return "/doctor/medical";
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/doctor/medical", params = {"save"})
    public String postMedical(@ModelAttribute MedicalDto medical) {
        
        ordinacijaFacade.save(medical);
        
        return "redirect:/doctor";
    }

}
