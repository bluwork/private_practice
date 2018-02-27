/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import org.springframework.data.domain.Page;

/**
 *
 * @author bobanlukic
 */
public interface OrdinacijaFacade {

    AppUser getDoctor(HttpServletRequest request);

    PatientDto getPatientDto(Long patientId);

    Medical getMedical(HttpServletRequest request, Long patientId);

    Vitals getVitals(Long patientId);

    List<Patient> getAllPatients();

    List<AppUser> getAllUsers();

    List<AppUser> getAllActiveDoctors();

    List<Patient> getScheduledPatients(LocalDate date);

    List<Patient> searchFor(String searchText);

    Page<Patient> getAllPatients(int pageNumber, int patientsByPage);

    boolean addAppUser(AppUserDto appUserDto);

    void deleteAppUser(Long userId);

    void suspendUser(Long userId);

    void reactivateUser(Long userId);

    boolean addPatient(PatientDto patientDto);

    void deletePatient(Long patientId);

    void saveVitals(Vitals vitals);

    void save(Medical medical);

}
