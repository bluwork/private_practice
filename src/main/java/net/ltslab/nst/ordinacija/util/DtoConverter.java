/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.util;

import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.ContactInfo;
import net.ltslab.nst.ordinacija.domain.Patient;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;

/**
 *
 * @author bobanlukic
 */
public class DtoConverter {

    public static Patient convertDtoToEntity(PatientDto patientDto) {
        
        Patient patient = new Patient();
        
        patient.setId(patientDto.getId());
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
        ci.setCity(patientDto.getCity());

        patient.setContactInfo(ci);

        return patient;
    }
    
    public static PatientDto convertEntityToDto(Patient patient) {
        
        PatientDto patientDto = new PatientDto();
        
        patientDto.setId(patient.getId());
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setMiddleName(patient.getMiddleName());
        patientDto.setLastName(patient.getLastName());
        patientDto.setBloodType(patient.getBloodType());
        patientDto.setGender(patient.getGender());
        patientDto.setDateOfBirth(patient.getDateOfBirth());
        patientDto.setAllergies(patient.getAllergies());
        patientDto.setAddress(patient.getContactInfo().getAddress());
        patientDto.setEmail(patient.getContactInfo().getEmail());
        patientDto.setPhone(patient.getContactInfo().getPhone());
        patientDto.setCity(patient.getContactInfo().getCity());
        
        

        return patientDto;
    }

    public static AppUser convertDtoToEntity(AppUserDto appUserDto) {
        
        AppUser appUser = new AppUser();
        
        appUser.setUsername(appUserDto.getUsername());
        appUser.setPassword(appUserDto.getPassword());
        appUser.setFirstName(appUserDto.getFirstName());
        appUser.setLastName(appUserDto.getLastName());
        appUser.setRoles(appUserDto.getRoles());
        
        return appUser;
    }
    
    public static AppUserDto convertEntityToDto(AppUser appUser) {
        
        AppUserDto appUserDto = new AppUserDto();
        
        appUserDto.setUsername(appUser.getUsername());
        appUserDto.setPassword(appUser.getPassword());
        appUserDto.setFirstName(appUser.getFirstName());
        appUserDto.setLastName(appUser.getLastName());
        appUserDto.setRoles(appUser.getRoles());
        
        return appUserDto;
    }
   

}
