/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;

/**
 *
 * @author bobanlukic
 */

public interface PatientService {
    List<Patient> getAllPatient();
    Patient getPatientById(Long id);
    void addOrUpdatePatient(Patient patient);
    void deletePatient(Long id);
}
