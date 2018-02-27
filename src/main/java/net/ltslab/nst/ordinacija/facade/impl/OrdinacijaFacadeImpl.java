/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.domain.enums.Role;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.service.VitalsService;
import net.ltslab.nst.ordinacija.util.DtoConverter;
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

        List<AppUser> availableUsers = appUserService.getAllActiveUsers();

        List<AppUser> availableDoctors = new ArrayList<>();

        for (AppUser user : availableUsers) {
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
        Patient p = DtoConverter.convertDtoToEntity(patientDto);
        if (patientService.getPatientById(p.getId()) == null) {
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
    public Vitals getVitalsFor(Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        Vitals vitals = new Vitals();
        vitals.setMeasuringDate(LocalDate.now());
        vitals.setPatient(patient);
        return vitals;
    }

    @Override
    public void saveVitals(Vitals vitals) {
        vitalsService.addOrUpdateVitals(vitals);
    }

    @Override
    public PatientDto getPatient(Long patientId) {
        return (DtoConverter.convertEntityToDto(patientService.getPatientById(patientId)));
    }

    @Override
    public Medical getMedicalFor(HttpServletRequest request, Long patientId) {

        Patient patient = patientService.getPatientById(patientId);

        String doctorName = request.getUserPrincipal().getName();
        AppUser doctor = appUserService.findByUsername(doctorName);

        return new Medical(patient, doctor, LocalDateTime.now());
    }

    @Override
    public void save(Medical medical) {
        medicalService.addOrUpdate(medical);
    }

    @Override
    public AppUser getDoctor(HttpServletRequest request) {

        String doctorName = request.getUserPrincipal().getName();
        return appUserService.findByUsername(doctorName);
    }

    @Override
    public boolean addAppUser(AppUserDto appUserDto) {
        AppUser appUser = DtoConverter.convertDtoToEntity(appUserDto);
        if (appUserService.findByUsername(appUser.getUsername()) == null) {
            appUserService.addOrUpdateUser(appUser);
            return true;
        }
        return false;
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
