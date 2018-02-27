/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade.impl;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.service.VitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import net.ltslab.nst.ordinacija.service.MedicalService;

/**
 *
 * @author bobanlukic
 */


@Component
public class OrdinacijaFacadeImpl implements OrdinacijaFacade {

    @Autowired
    PatientService patientService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    VitalsService vitalsService;

    @Autowired
    MedicalService medicalService;

    @Override
    public List<Patient> getAllPatients() {
        
        return patientService.allPatients();
        
    }

    @Override
    public List<AppUser> getAllActiveDoctors() {
        return appUserService.getAllActiveDoctors();
    }

    @Override
    public List<Patient> getScheduledPatients(LocalDate date) {
        return patientService.scheduledForDate(date);
    }

    @Override
    public boolean addPatient(PatientDto patientDto) {
        return patientService.addPatient(patientDto);     
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
        return patientService.searchForPatient(searchText);
    }

    @Override
    public Vitals getVitals(Long patientId) {
        return vitalsService.getVitals(patientId);
    }

    @Override
    public void saveVitals(Vitals vitals) {
        vitalsService.addOrUpdateVitals(vitals);
    }

    @Override
    public PatientDto getPatientDto(Long patientId) {
        return patientService.getPatientDto(patientId);
    }

    @Override
    public Medical getMedical(HttpServletRequest request, Long patientId) {
        return medicalService.getMedical(request, patientId);
    }

    @Override
    public void save(Medical medical) {
        medicalService.addOrUpdate(medical);
    }

    @Override
    public AppUser getDoctor(HttpServletRequest request) {
        return appUserService.getDoctor(request);    
    }

    @Override
    public boolean addAppUser(AppUserDto appUserDto) {
        return appUserService.addAppUser(appUserDto);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @Override
    public void deleteAppUser(Long userId) {
        appUserService.deleteAppUser(userId);
    }

    @Override
    public void suspendUser(Long userId) {
        appUserService.suspendUser(userId);
    }

    @Override
    public void reactivateUser(Long userId) {
        appUserService.reactivateUser(userId);
    }

}
