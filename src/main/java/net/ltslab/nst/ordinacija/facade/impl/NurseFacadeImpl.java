/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.domain.enums.Role;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.facade.NurseFacade;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.service.VitalsService;
import net.ltslab.nst.ordinacija.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 *
 * @author bobanlukic
 */
@Component
public class NurseFacadeImpl implements NurseFacade{

    @Autowired
    PatientService patientService;
    
    @Autowired
    AppUserService appUserService;
    
    @Autowired
    VitalsService vitalsService;
    
    @Override
    public List<Patient> getAllPatients() {
        return patientService.allPatients();
    }

    @Override
    public List<AppUser> getAllActiveDoctors() {
        
        List<AppUser> availableUsers = appUserService.getAllActiveUsers();
        
        List<AppUser> availableDoctors = new ArrayList<>();
        
        for (AppUser user: availableUsers) {
            if (user.getRoles().contains(Role.DOCTOR)) {
                availableDoctors.add(user);
            }
        }
        
        return availableDoctors;
    }

    @Override
    public List<Patient> getScheduledPatients(LocalDate date) {
        return patientService.scheduledForDate(date);
    }

    @Override
    public boolean addPatient(PatientDto patientDto) {
        Patient p = Converter.convertDtoToEntity(patientDto);
        if (patientService.getPatientById(p.getId()) == null){
            patientService.addOrUpdatePatient(p);
            return true;
        }
        return false;
    }

    @Override
    public Page<Patient> getAllPatients(int pageNumber, int patientsByPage) {
        return patientService.getPatientsByPage(pageNumber, patientsByPage);
    }

    @Override
    public void deletePatient(Long patientId) {
        patientService.deletePatient(patientId);
    }

    @Override
    public List<Patient> searchFor(String searchText) {
        List searchResults = null;
        try {
            searchResults = patientService.searchForPatient(searchText);
        } catch (Exception ex) {
        }
        return searchResults;
    }

    @Override
    public Vitals addVitalsFor(Long patientId) {
       Patient patient = patientService.getPatientById(patientId);
       Vitals vitals = new Vitals();
       vitals.setMeasuringDate(LocalDate.now());
       vitals.setPatient(patient);
       return vitals;
    }

    @Override
    public void addVitals(Vitals vitals) {
        vitalsService.addOrUpdateVitals(vitals);
    }
    
}
