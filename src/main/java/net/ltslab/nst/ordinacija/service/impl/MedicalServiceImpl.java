/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import net.ltslab.nst.ordinacija.repository.MedicalRepository;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.MedicalService;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.util.AppUserMapper;
import net.ltslab.nst.ordinacija.util.MedicalMapper;
import net.ltslab.nst.ordinacija.util.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    MedicalRepository medicalRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    MedicalMapper medicalMapper;

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    AppUserMapper appUserMappper;

    @Override
    public void addOrUpdate(MedicalDto medicalDto) {
        medicalRepository.saveAndFlush(medicalMapper.medicalDtoToMedical(medicalDto));
    }

    @Override
    public MedicalDto getMedicalDto(HttpServletRequest request, Long patientId) {

        Patient patient = patientMapper.patientDtoToPatient(patientService.getPatientById(patientId));
        System.out.println(patient);
        String doctorName = request.getUserPrincipal().getName();
       
        AppUser doctor = appUserMappper.appUserDtoToAppUser(appUserService.findByUsername(doctorName));
        System.out.println(doctor);
        
        return medicalMapper.medicalToMedicalDto(new Medical(patient, doctor, LocalDateTime.now()));
    }

}
