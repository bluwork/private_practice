/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.Prescription;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
import net.ltslab.nst.ordinacija.dto.CityDto;
import net.ltslab.nst.ordinacija.dto.DiagnosisDto;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.dto.VitalsDto;

/**
 *
 * @author bobanlukic
 */
public interface OrdinacijaFacade {

    AppUserDto getDoctor(HttpServletRequest request);

    AppUserDto getAppUserDto(Long id);

    PatientDto getPatientDto(String patientId);

    MedicalDto getMedicalDto(HttpServletRequest request, String patientId);

    VitalsDto getVitalsDto(String patientId);

    AppointmentDto getAppointmentDto();

    List<AppUserDto> getAllUsers();

    List<PatientDto> getAllPatients();

    List<PatientDto> getAllActivePatients();

    List<AppUserDto> getAllActiveDoctors();

    List<PatientDto> getScheduledPatients(HttpServletRequest request);

    List<PatientDto> searchFor(String searchText);

    List<PatientDto> getAllScheduledPatients(LocalDate date);

    List<CityDto> getAllCities();

    List<AppointmentDto> getAllAppointmentDtos(LocalDate date, AppUserDto doctor);

    boolean addAppUser(AppUserDto appUserDto);

    boolean suspendUser(Long userId);

    void reactivateUser(Long userId);

    boolean addPatient(PatientDto patientDto);

    void softDeletePatient(String patientId);

    void saveVitals(VitalsDto vitals);

    void save(MedicalDto medical);

    boolean addCity(CityDto cityDto);

    void updateUser(AppUserDto appUserDto);

    void addAppointment(AppointmentDto appointmentDto);

    void sendEmail(PatientDto patientDto, String subject, String message);

    boolean isAppointedAlreadyForDate(PatientDto patient, LocalDate date);

    CityDto getCityDto(Long zipCode);

    void updateCity(CityDto cityDto);

    List<PatientDto> getAllPatientsAddedByDate(LocalDate now);

    List<DiagnosisDto> getDiagnoses();

    boolean addDiagnosis(DiagnosisDto diagnosisDto);

    void updateDiagnosis(DiagnosisDto diagnosisDto);

    DiagnosisDto getDiagnosisDto(String code);

    void updatePatient(PatientDto patientDto);

    List<PatientDto> getAllFinishedPatients(LocalDate date);

    List<AppointmentDto> getAllAppointmentDtosAfter(PatientDto patientDto, LocalDate date);

    void deleteAppointment(Long appointmentId);

    void sendAppointmentConfirmationMail(AppointmentDto appointmentDto);

    public void postPrescriptions(String patientId, List<Prescription> prescriptions);

}
