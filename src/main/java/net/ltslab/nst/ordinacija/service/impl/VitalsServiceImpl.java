/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.dto.VitalsDto;
import net.ltslab.nst.ordinacija.service.VitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import net.ltslab.nst.ordinacija.repository.VitalsRepository;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.util.PatientMapper;
import net.ltslab.nst.ordinacija.util.VitalsMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class VitalsServiceImpl implements VitalsService {

    @Autowired
    VitalsRepository vitalsRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    VitalsMapper vitalsMapper;

    @Autowired
    PatientMapper patientMapper;

    @Override
    public List<VitalsDto> getAllVitals(Long patientId) {
        return vitalsMapper.vitalsToVitalsDtos(vitalsRepository.findByPatientId(patientId));
    }

    @Override
    public VitalsDto getVitalsDto(Long patientId) {
        Patient patient = patientMapper.patientDtoToPatient(patientService.getPatientById(patientId));
        Vitals vitals = new Vitals();
        vitals.setMeasuringDate(LocalDate.now());
        vitals.setPatient(patient);
        return vitalsMapper.vitalsToVitalsDto(vitals);
    }

    @Override
    public void addOrUpdateVitals(VitalsDto vitalsDto) {
        vitalsRepository.saveAndFlush(vitalsMapper.vitalsDtoToVitals(vitalsDto));
    }

    @Override
    public void deleteVitals(Long id) {
        vitalsRepository.delete(id);
    }

}
