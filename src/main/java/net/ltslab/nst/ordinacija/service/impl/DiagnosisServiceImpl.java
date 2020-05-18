/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Diagnosis;
import net.ltslab.nst.ordinacija.dto.DiagnosisDto;
import net.ltslab.nst.ordinacija.mapping.DiagnosisMapper;
import net.ltslab.nst.ordinacija.repository.DiagnosisRepository;
import net.ltslab.nst.ordinacija.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @Override
    public List<DiagnosisDto> allDiagnoses() {
        return diagnosisMapper.diagnosesToDiagnosisDtos(diagnosisRepository.findAll());
    }

    @Override
    public boolean addDiagnosis(DiagnosisDto diagnosisDto) {
        Diagnosis diagnosis = diagnosisMapper.diagnosisDtoToDiagnosis(diagnosisDto);
        if (diagnosisRepository.findDiagnosisByCode(diagnosis.getCode()) == null) {
            diagnosisRepository.saveAndFlush(diagnosis);
            return true;
        }
        return false;
    }

    @Override
    public void updateDiagnosis(DiagnosisDto diagnosisDto) {
        diagnosisRepository.saveAndFlush(diagnosisMapper.diagnosisDtoToDiagnosis(diagnosisDto));
    }

    @Override
    public DiagnosisDto getDiagnosisByCode(String code) {
        return diagnosisMapper.diagnosisToDiagnosisDto(diagnosisRepository.getOne(code));
    }
}
