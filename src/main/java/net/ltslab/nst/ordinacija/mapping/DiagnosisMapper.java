/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.mapping;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Diagnosis;
import net.ltslab.nst.ordinacija.dto.DiagnosisDto;
import org.mapstruct.Mapper;

/**
 *
 * @author bobanlukic
 */
@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    DiagnosisDto diagnosisToDiagnosisDto(Diagnosis diagnosis);

    Diagnosis diagnosisDtoToDiagnosis(DiagnosisDto diagnosisDto);

    List<DiagnosisDto> diagnosesToDiagnosisDtos(List<Diagnosis> diagnoses);

}
