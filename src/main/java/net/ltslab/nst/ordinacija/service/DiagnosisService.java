/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.List;
import net.ltslab.nst.ordinacija.dto.DiagnosisDto;

/**
 *
 * @author bobanlukic
 */
public interface DiagnosisService {
    
    List<DiagnosisDto> allDiagnoses();

    boolean addDiagnosis(DiagnosisDto diagnosisDto);

    void updateDiagnosis(DiagnosisDto diagnosisDto);

    DiagnosisDto getDiagnosisByCode(String code);
}
