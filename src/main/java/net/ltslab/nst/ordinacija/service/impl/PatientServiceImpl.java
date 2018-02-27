/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.repository.impl.PatientSearchRepositoryImpl;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import net.ltslab.nst.ordinacija.repository.PatientRepository;
import net.ltslab.nst.ordinacija.util.DtoConverter;

/**
 *
 * @author bobanlukic
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired // TODO Videti da li da se ovo objedini u jednu klasu - da i search radi isti repository odozgo
    PatientSearchRepositoryImpl patientSearchRepository;

    @Override
    public List<Patient> allPatients() {
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

    @Override
    public Page<Patient> getPatientsByPage(int pageNumber, int itemsByPage) {
        return patientRepository.findAll(new PageRequest(pageNumber, itemsByPage));
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public List<Patient> scheduledForDate(LocalDate date) {
        return patientRepository.findByMedScheduleDateOrderByMedScheduleTimeAsc(date);
    }

    @Override
    public List<Patient> searchForPatient(String searchText) {
        return patientSearchRepository.search(searchText);
    }

    @Override
    public boolean addPatient(PatientDto patientDto) {
        Patient p = DtoConverter.convertDtoToEntity(patientDto);
        if (getPatientById(p.getId()) == null) {
            addOrUpdatePatient(p);
            return true;
        }
        return false;
    }

}
