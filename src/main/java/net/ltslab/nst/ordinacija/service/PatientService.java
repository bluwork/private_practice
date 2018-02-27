/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import org.springframework.data.domain.Page;

/**
 *
 * @author bobanlukic
 */
public interface PatientService {

    List<Patient> allPatients();

    Patient getPatientById(Long id);

    void addOrUpdatePatient(Patient patient);

    void deletePatient(Long id);

    Page<Patient> getPatientsByPage(int pageNumber, int itemsByPage);

    void deletePatient(Patient patient);

    public List<Patient> scheduledForDate(LocalDate date);

    List<Patient> searchForPatient(String searchText);

    public boolean addPatient(PatientDto patientDto);
}
