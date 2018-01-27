/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.repository.PatientRepository;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired 
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findOne(id);
    }

    @Override
    public void addOrUpdatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.delete(id);
    }
    
}
