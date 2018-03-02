/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade.impl;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.CityDto;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.dto.VitalsDto;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.service.VitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import net.ltslab.nst.ordinacija.service.CityService;
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

    @Autowired
    CityService cityService;

    @Override
    public List<PatientDto> getAllPatients() {
        return patientService.allPatients();
    }

    @Override
    public List<AppUserDto> getAllActiveDoctors() {
        return appUserService.getAllActiveDoctors();
    }

    @Override
    public List<PatientDto> getScheduledPatients(LocalDate date) {
        return patientService.scheduledForDate(date);
    }

    @Override
    public boolean addPatient(PatientDto patientDto) {
        return patientService.addPatient(patientDto);
    }

    @Override
    public void deletePatient(Long patientId) {

        patientService.deletePatient(patientId);

    }

    @Override
    public List<PatientDto> searchFor(String searchText) {
        return patientService.searchForPatients(searchText);
    }

    @Override
    public VitalsDto getVitals(Long patientId) {
        return vitalsService.getVitalsDto(patientId);
    }

    @Override
    public void saveVitals(VitalsDto vitalsDto) {
        vitalsService.addOrUpdateVitals(vitalsDto);
    }

    @Override
    public MedicalDto getMedicalDto(HttpServletRequest request, Long patientId) {
        return medicalService.getMedicalDto(request, patientId);
    }

    @Override
    public void save(MedicalDto medicalDto) {
        medicalService.addOrUpdate(medicalDto);
    }

    @Override
    public AppUserDto getDoctor(HttpServletRequest request) {
        return appUserService.getDoctor(request);
    }

    @Override
    public boolean addAppUser(AppUserDto appUserDto) {
        return appUserService.addAppUser(appUserDto);
    }

    @Override
    public List<AppUserDto> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @Override
    public void suspendUser(Long userId) {
        appUserService.suspendUser(userId);
    }

    @Override
    public void reactivateUser(Long userId) {
        appUserService.reactivateUser(userId);
    }

    @Override
    public PatientDto getPatientDto(Long patientId) {
        return patientService.getPatientDto(patientId);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityService.allCities();
    }

    @Override
    public boolean addCity(CityDto cityDto) {
        return cityService.addCity(cityDto);
    }

}
