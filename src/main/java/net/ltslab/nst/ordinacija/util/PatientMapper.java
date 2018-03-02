/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.util;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.ContactInfo;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.ContactInfoDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import org.mapstruct.Mapper;

/**
 *
 * @author bobanlukic
 */
@Mapper(componentModel = "spring", uses = CityMapper.class)
public interface PatientMapper {

    PatientDto patientToPatientDto(Patient patient);

    Patient patientDtoToPatient(PatientDto patientDto);

    ContactInfo contactInfoToContactInfoDto(ContactInfoDto contactInfoDto);

    ContactInfoDto conctactInfoDtoToContactInfo(ContactInfo contactInfo);

    List<PatientDto> patientsToPatientDtos(List<Patient> patients);
}
