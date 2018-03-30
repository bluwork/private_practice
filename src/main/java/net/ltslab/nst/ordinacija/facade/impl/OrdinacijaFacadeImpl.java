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
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
import net.ltslab.nst.ordinacija.dto.CityDto;
import net.ltslab.nst.ordinacija.dto.DiagnosisDto;
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
import net.ltslab.nst.ordinacija.service.DiagnosisService;
import net.ltslab.nst.ordinacija.service.MailSenderService;
import net.ltslab.nst.ordinacija.service.MedicalService;

/**
 *
 * @author bobanlukic
 */
@Component
public class OrdinacijaFacadeImpl implements OrdinacijaFacade {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private VitalsService vitalsService;

    @Autowired
    private MedicalService medicalService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private MailSenderService mailSenderService;
    
    @Autowired
    private DiagnosisService diagnosisService;

    @Override
    public AppUserDto getDoctor(HttpServletRequest request) {
        return appUserService.getDoctorDto(request);
    }

    @Override
    public AppUserDto getAppUserDto(Long id) {
        return appUserService.getById(id);
    }

    @Override
    public PatientDto getPatientDto(String patientId) {
        return patientService.getPatientById(patientId);
    }

    @Override
    public MedicalDto getMedicalDto(HttpServletRequest request, String patientId) {
        return medicalService.getMedicalDto(request, patientId);
    }

    @Override
    public VitalsDto getVitalsDto(String patientId) {
        return vitalsService.getVitalsDto(patientId);
    }

    @Override
    public AppointmentDto getAppointmentDto() {
        return appointmentService.getAppointmentDto();
    }

    @Override
    public List<AppUserDto> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientService.allPatients();
    }

    @Override
    public List<PatientDto> getAllActivePatients() {
        return patientService.activePatients();
    }

    @Override
    public List<AppUserDto> getAllActiveDoctors() {
        return appUserService.getAllActiveDoctors();
    }

    @Override
    public List<PatientDto> getScheduledPatients(HttpServletRequest request) {
        return patientService.sheduledForDoctor(request);
    }

    @Override
    public List<PatientDto> searchFor(String searchText) {
        return patientService.searchForPatients(searchText);
    }

    @Override
    public List<PatientDto> getAllScheduledPatients(LocalDate date) {
        return patientService.scheduledForDate(date);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityService.allCities();
    }

    @Override
    public List<AppointmentDto> getAllAppointmentDtos(LocalDate date, AppUserDto doctor) {
        return appointmentService.getAllAppointmentDtos(date, doctor);
    }

    @Override
    public boolean addAppUser(AppUserDto appUserDto) {
        return appUserService.addAppUser(appUserDto);
    }

    @Override
    public boolean suspendUser(Long userId) {
        return appUserService.suspendUser(userId);
    }

    @Override
    public void reactivateUser(Long userId) {
        appUserService.reactivateUser(userId);
    }

    @Override
    public boolean addPatient(PatientDto patientDto) {
        return patientService.addPatient(patientDto);
    }

    @Override
    public void softDeletePatient(String patientId) {
        patientService.softDeletePatient(patientId);

    }

    @Override
    public void saveVitals(VitalsDto vitalsDto) {
        vitalsService.addOrUpdateVitals(vitalsDto);
    }

    @Override
    public void save(MedicalDto medicalDto) {
        medicalService.addOrUpdate(medicalDto);
    }

    @Override
    public boolean addCity(CityDto cityDto) {
        return cityService.addCity(cityDto);
    }

    @Override
    public void updateUser(AppUserDto appUserDto) {
        appUserService.updateUser(appUserDto);
    }

    @Override
    public void addAppointment(AppointmentDto appointmentDto) {
        appointmentService.addAppointment(appointmentDto);
    }

    @Override
    public void sendEmail(PatientDto patientDto, String subject, String text) {
        mailSenderService.sendEmail(patientDto, subject, text);
    }

    @Override
    public boolean isAppointedAlreadyForDate(PatientDto patient, LocalDate date) {
        return appointmentService.isAppointedAlreadyForDate(patient, date);
    }

    @Override
    public CityDto getCityDto(Long zipCode) {
        return cityService.getCityByZipCode(zipCode);
    }

    @Override
    public void updateCity(CityDto cityDto) {
        cityService.updateCity(cityDto);
    }

    @Override
    public List<PatientDto> getAllPatientsAddedByDate(LocalDate date) {
        return patientService.getAllPatientsAddedByDate(date);
    }

    @Override
    public List<DiagnosisDto> getDiagnoses() {
        return diagnosisService.allDiagnoses();
    }

    @Override
    public boolean addDiagnosis(DiagnosisDto diagnosisDto) {
        return diagnosisService.addDiagnosis(diagnosisDto);
    }

    @Override
    public void updateDiagnosis(DiagnosisDto diagnosisDto) {
        diagnosisService.updateDiagnosis(diagnosisDto);
    }

    @Override
    public DiagnosisDto getDiagnosisDto(String code) {
        return diagnosisService.getDiagnosisByCode(code);
    }

    @Override
    public void updatePatient(PatientDto patientDto) {
        patientService.updatePatient(patientDto);
    }

    @Override
    public List<PatientDto> getAllFinishedPatients(LocalDate date) {
        return patientService.finishedForDate(date);
    }

    @Override
    public List<AppointmentDto> getAllAppointmentDtosAfter(PatientDto patientDto, LocalDate date) {
        return appointmentService.getAllAppointmentDtosAfter(patientDto, date);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }

}
