/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.mapping;

import net.ltslab.nst.ordinacija.domain.Prescription;
import net.ltslab.nst.ordinacija.dto.PrescriptionDto;
import org.mapstruct.Mapper;

/**
 *
 * @author bobanlukic
 */
@Mapper(componentModel = "spring")
public interface PrescriptionMapper {
    Prescription prescriptionDtoToPrescription(PrescriptionDto prescriptionDto);
    PrescriptionDto prescriptionToPrescriptionDto(Prescription prescription);
}
