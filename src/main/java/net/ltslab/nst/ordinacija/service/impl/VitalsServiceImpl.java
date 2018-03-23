/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.dto.VitalsDto;
import net.ltslab.nst.ordinacija.service.VitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import net.ltslab.nst.ordinacija.repository.VitalsRepository;
import net.ltslab.nst.ordinacija.service.PatientService;
import net.ltslab.nst.ordinacija.mapping.VitalsMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class VitalsServiceImpl implements VitalsService {

    @Autowired
    private VitalsRepository vitalsRepository;

    @Autowired
    private VitalsMapper vitalsMapper;
    
    @Autowired
    private PatientService patientService;

    @Override
    public List<VitalsDto> getAllVitals(Long patientId) {
        return vitalsMapper.vitalsToVitalsDtos(vitalsRepository.findByPatientId(patientId));
    }

    @Override
    public VitalsDto getVitalsDto(Long patientId) {
        PatientDto patient = patientService.getPatientById(patientId);
        VitalsDto vitalsDto = new VitalsDto();
        vitalsDto.setMeasuringDate(LocalDate.now());
        vitalsDto.setPatient(patient);
        return vitalsDto;
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
