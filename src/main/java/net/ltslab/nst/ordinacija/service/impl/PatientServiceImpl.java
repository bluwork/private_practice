/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Appointment;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.repository.impl.PatientSearchRepositoryImpl;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.ltslab.nst.ordinacija.repository.PatientRepository;
import net.ltslab.nst.ordinacija.mapping.PatientMapper;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.AppointmentService;

/**
 *
 * @author bobanlukic
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PatientSearchRepositoryImpl patientSearchRepository;

    @Override
    public List<PatientDto> allPatients() {
        return patientMapper.patientsToPatientDtos(patientRepository.findAll());
    }

    @Override
    public PatientDto getPatientById(String id) {
        return patientMapper.patientToPatientDto(patientRepository.findPatientById(id));
    }

    @Override
    public void addOrUpdatePatient(PatientDto patientDto) {
        patientRepository.save(patientMapper.patientDtoToPatient(patientDto));
    }

    @Override
    public void softDeletePatient(String id) {
        Patient softDeletedPatient = patientRepository.findPatientById(id);
        softDeletedPatient.setSoftDeleted(true);
        patientRepository.saveAndFlush(softDeletedPatient);
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
    public List<PatientDto> activePatients() {
        return patientMapper.patientsToPatientDtos(patientRepository.findBySoftDeletedFalse());
    }

    @Override
    public List<PatientDto> sheduledForDoctor(HttpServletRequest request) {
        AppUser currentDoctor = appUserService.getDoctor(request);
        List<Appointment> appointments = appointmentService.findByDoctorAndDateAndRealizedFalse(currentDoctor, LocalDate.now());
        List<Patient> patients = new ArrayList<>();
        for (Appointment a : appointments) {
            patients.add(a.getPatient());
        }
        return patientMapper.patientsToPatientDtos(patients);
    }

    @Override
    public List<PatientDto> scheduledForDate(LocalDate date) {
        List<Appointment> appointments = appointmentService.findByDateAndRealizedFalse(LocalDate.now());
        List<Patient> patients = new ArrayList<>();
        for (Appointment a : appointments) {
            patients.add(a.getPatient());
        }
        return patientMapper.patientsToPatientDtos(patients);
    }

    @Override
    public List<PatientDto> getAllPatientsAddedByDate(LocalDate date) {
        return patientMapper.patientsToPatientDtos(patientRepository.findByDateAdded(date));
    }

    @Override
    public void updatePatient(PatientDto patientDto) {
        patientRepository.saveAndFlush(patientMapper.patientDtoToPatient(patientDto));
    }

    @Override
    public List<PatientDto> finishedForDate(LocalDate date) {
       List<Appointment> appointments = appointmentService.findByDateAndRealizedTrue(LocalDate.now());
       List<Patient> patients = new ArrayList<>();
       for (Appointment a : appointments) {
           patients.add(a.getPatient());
       }
       return patientMapper.patientsToPatientDtos(patients);
    }
}
