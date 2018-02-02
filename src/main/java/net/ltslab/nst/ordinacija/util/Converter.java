/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.util;

import net.ltslab.nst.ordinacija.domain.ContactInfo;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.PatientDto;

/**
 *
 * @author asdf
 */
public class Converter {
 
    public static Patient convertDtoToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setMiddleName(patientDto.getMiddleName());
        patient.setLastName(patientDto.getLastName());
        patient.setBloodType(patientDto.getBloodType());
        patient.setGender(patientDto.getGender());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setAllergies(patientDto.getAllergies());
        
        ContactInfo ci = new ContactInfo();
        ci.setPatient(patient);
        ci.setAddress(patientDto.getAddress());
        ci.setEmail(patientDto.getEmail());
        ci.setPhone(patientDto.getPhone());
        
        patient.setContactInfo(ci);
        
        return patient;
    }
    
}
