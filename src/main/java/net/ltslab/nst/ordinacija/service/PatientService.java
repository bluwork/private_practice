/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.dto.PatientDto;

/**
 *
 * @author bobanlukic
 */

public interface PatientService {

    List<PatientDto> allPatients();

    List<PatientDto> activePatients();

    List<PatientDto> scheduledForDate(LocalDate date);

    List<PatientDto> sheduledForDoctor(HttpServletRequest request);

    List<PatientDto> searchForPatients(String searchText);

    PatientDto getPatientById(String id);

    void addOrUpdatePatient(PatientDto patient);

    void softDeletePatient(String id);

    boolean addPatient(PatientDto patientDto);

    List<PatientDto> getAllPatientsAddedByDate(LocalDate date);

    void updatePatient(PatientDto patientDto);

    List<PatientDto> finishedForDate(LocalDate date);

}
