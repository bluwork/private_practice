/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.CityDto;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.dto.VitalsDto;

/**
 *
 * @author bobanlukic
 */
public interface OrdinacijaFacade {

    AppUserDto getDoctor(HttpServletRequest request);

    PatientDto getPatientDto(Long patientId);

    MedicalDto getMedicalDto(HttpServletRequest request, Long patientId);

    VitalsDto getVitals(Long patientId);

    List<PatientDto> getAllPatients();

    List<AppUserDto> getAllUsers();

    List<AppUserDto> getAllActiveDoctors();

    List<PatientDto> getScheduledPatients(LocalDate date);

    List<PatientDto> searchFor(String searchText);

    List<CityDto> getAllCities();

    boolean addAppUser(AppUserDto appUserDto);

    void suspendUser(Long userId);

    void reactivateUser(Long userId);

    boolean addPatient(PatientDto patientDto);

    void deletePatient(Long patientId);

    void saveVitals(VitalsDto vitals);

    void save(MedicalDto medical);

    boolean addCity(CityDto cityDto);

}
