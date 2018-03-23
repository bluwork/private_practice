/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.domain.enums.BloodType;
import net.ltslab.nst.ordinacija.domain.enums.Gender;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bobanlukic
 */
public class PatientDto implements Serializable {

    private static final long serialVersionUID = 9121707642309561697L;

    private Long id;
    
    private String firstName;
    
    private String lastName;
    
    private String middleName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    private Gender gender;
    
    private BloodType bloodType;
    
    private String allergies;

    private ContactInfoDto contactInfo;

    private List<Vitals> vitals;

    private List<Medical> medicals;

    public PatientDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactInfoDto getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoDto contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Vitals> getVitals() {
        return vitals;
    }

    public void setVitals(List<Vitals> vitals) {
        this.vitals = vitals;
    }

    public List<Medical> getMedicals() {
        return medicals;
    }

    public void setMedicals(List<Medical> medicals) {
        this.medicals = medicals;
    }

}
