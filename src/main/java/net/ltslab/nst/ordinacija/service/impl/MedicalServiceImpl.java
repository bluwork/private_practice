/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.Prescription;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.repository.MedicalRepository;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.MedicalService;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.mapping.MedicalMapper;
import net.ltslab.nst.ordinacija.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    private MedicalRepository medicalRepository;

    @Autowired
    private MedicalMapper medicalMapper;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppUserService appUserService;
    
    @Autowired
    private AppointmentService appointmentService;

    @Override
    public void addOrUpdate(MedicalDto medicalDto) {
        
        appointmentService.confirmAppointmentRealization(medicalDto.getPatient(), LocalDate.now());
        medicalRepository.save(medicalMapper.medicalDtoToMedical(medicalDto));
    }

    @Override
    public MedicalDto getMedicalDto(HttpServletRequest request, String patientId) {

        PatientDto patient = patientService.getPatientById(patientId);
        AppUserDto doctor = appUserService.findByUsername(request.getUserPrincipal().getName());
        
        
        MedicalDto medicalDto = new MedicalDto();
        medicalDto.setDoctor(doctor);
        medicalDto.setPatient(patient);
        medicalDto.setMedicalDate(LocalDateTime.now());
        for (int i = 0; i < 3; i ++) {
            medicalDto.getPrescriptions().add(new Prescription());
        }
        return medicalDto;
    }

}
