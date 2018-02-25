/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.facade;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import org.springframework.data.domain.Page;

/**
 *
 * @author bobanlukic
 */

public interface NurseFacade {
    List<Patient> getAllPatients();
    List<AppUser> getAllActiveDoctors();
    List<Patient> getScheduledPatients(LocalDate date);

    boolean addPatient(PatientDto patientDto);

    Page<Patient> getAllPatients(int pageNumber, int patientsByPage);

    void deletePatient(Long patientId);

    List<Patient> searchFor(String searchText);

    Vitals addVitalsFor(Long patientId);

    void addVitals(Vitals vitals);
}
