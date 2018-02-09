/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.MedicalService;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author bobanlukic
 */

@Controller
public class DoctorController {
    
    @Autowired
    PatientService patientService;
    
    @Autowired
    MedicalService medicalService;
    
    @Autowired
    AppUserService appUserService;
            
    @RequestMapping("/doctor")
    public String doctorPage(/*Model model*/) {
        //model.addAttribute("attribute", "value");
        return "/doctor";
    }
    
    @RequestMapping("/doctor/medical")
    public String medical(HttpServletRequest request, Model model) {
        
        Patient patient = patientService.getPatientById(22345678L);
        String doctorName = request.getUserPrincipal().getName();
        AppUser doctor = appUserService.findByUsername(doctorName);
       
        model.addAttribute("medical", new Medical(patient, doctor, new Date()));
        return "/doctor/medical";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/doctor/new_medical")
    public String addMedical(@ModelAttribute Medical medical) {
        medicalService.addOrUpdate(medical);
        return "/doctor";
    }
        
}
