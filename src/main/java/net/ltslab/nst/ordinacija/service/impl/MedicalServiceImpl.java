/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.repository.MedicalRepository;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.MedicalService;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    MedicalRepository medicalRepository;
    
    @Autowired
    PatientService patientService;
    
    @Autowired
    AppUserService appUserService;

    @Override
    public void addOrUpdate(Medical medical) {
        medicalRepository.save(medical);
    }

    @Override
    public Medical getMedical(HttpServletRequest request, Long patientId) {
        
        Patient patient = patientService.getPatientById(patientId);
        String doctorName = request.getUserPrincipal().getName();
        AppUser doctor = appUserService.findByUsername(doctorName);
        return new Medical(patient, doctor, LocalDateTime.now());
        
    }

}
