/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.util;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.dto.MedicalDto;
import org.mapstruct.Mapper;

/**
 *
 * @author bobanlukic
 */
@Mapper(componentModel = "spring", uses = PatientMapper.class)
public interface MedicalMapper {

    MedicalDto medicalToMedicalDto(Medical medical);

    Medical medicalDtoToMedical(MedicalDto medicalDto);

    List<MedicalDto> medicalsToMedicalsDtos(List<Medical> medicals);
}
