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
import net.ltslab.nst.ordinacija.repository.PatientRepository;
import net.ltslab.nst.ordinacija.util.PatientMapper;

/**
 *
 * @author bobanlukic
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientMapper patientMapper;

    @Autowired // TODO Videti da li da se ovo objedini u jednu klasu - da i search radi isti repository odozgo
    PatientSearchRepositoryImpl patientSearchRepository;

    @Override
    public List<PatientDto> allPatients() {
        return patientMapper.patientsToPatientDtos(patientRepository.findAll());
    }

    @Override
    public PatientDto getPatientById(Long id) {
        return patientMapper.patientToPatientDto(patientRepository.findOne(id));
    }

    @Override
    public void addOrUpdatePatient(PatientDto patientDto) {
        patientRepository.save(patientMapper.patientDtoToPatient(patientDto));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.delete(id);
    }

    @Override
    public void deletePatient(PatientDto patientDto) {
        patientRepository.delete(patientMapper.patientDtoToPatient(patientDto));
    }

    @Override
    public List<PatientDto> scheduledForDate(LocalDate date) {
        return patientMapper.patientsToPatientDtos(patientRepository.findByMedScheduleDateOrderByMedScheduleTimeAsc(date));
    }

    @Override
    public List<PatientDto> searchForPatients(String searchText) {
        return patientMapper.patientsToPatientDtos(patientSearchRepository.search(searchText));
    }

    @Override
    public boolean addPatient(PatientDto patientDto) {
        Patient p = patientMapper.patientDtoToPatient(patientDto);
        if (getPatientById(p.getId()) == null) {
            patientRepository.saveAndFlush(p);
            return true;
        }
        return false;
    }

    @Override
    public PatientDto getPatientDto(Long patientId) {
        return patientMapper.patientToPatientDto(patientRepository.findOne(patientId));
    }

}
