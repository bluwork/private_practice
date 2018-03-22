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
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
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
import net.ltslab.nst.ordinacija.service.AppointmentService;
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
    
    @Autowired
    AppointmentService appointmentService;

    @Override
    public List<PatientDto> getAllPatients() {
        return patientService.allPatients();
    }

    @Override
    public List<AppUserDto> getAllActiveDoctors() {
        return appUserService.getAllActiveDoctors();
    }

    @Override
    public boolean addPatient(PatientDto patientDto) {
        return patientService.addPatient(patientDto);
    }

    @Override
    public void softDeletePatient(Long patientId) {

        patientService.softDeletePatient(patientId);

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
        return appUserService.getDoctorDto(request);
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

    @Override
    public List<PatientDto> getAllActivePatients() {
        return patientService.activePatients();
    }

    @Override
    public AppUserDto getAppUserDto(Long id) {
        return appUserService.getById(id);
    }

    @Override
    public void updateUser(AppUserDto appUserDto) {
        appUserService.updateUser(appUserDto);
    }

    @Override
    public List<PatientDto> getScheduledPatients(HttpServletRequest request) {
        return patientService.sheduledForDoctor(request);
    }

    @Override
    public List<PatientDto> getAllScheduledPatients(LocalDate date) {
        return patientService.scheduledForDate(date);
    }

    @Override
    public AppointmentDto getAppointmentDto() {
        return appointmentService.getAppointmentDto();
    }

    @Override
    public List<AppointmentDto> getAllAppointmentDtos(LocalDate date, AppUserDto doctor) {
        return appointmentService.getAllAppointmentDtos(date, doctor);
    }

    @Override
    public void addAppointment(AppointmentDto appointmentDto) {
        appointmentService.addAppointment(appointmentDto);
    }

}
