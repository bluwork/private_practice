/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.util.Date;
import net.ltslab.nst.ordinacija.domain.enums.BloodType;
import net.ltslab.nst.ordinacija.domain.enums.Gender;

/**
 *
 * @author bobanlukic
 */
public class PatientDtoBuilder {
    
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private Gender gender;
    private BloodType bloodType;
    private String phone;
    private String email;
    private String address;
    private String cityName;
    private String allergies;

    public PatientDtoBuilder() {
    }
    
    public PatientDto build() {
        return new PatientDto(firstName, lastName, middleName, dateOfBirth, gender, bloodType, phone, email, address, cityName, allergies);
    }
    
    public PatientDtoBuilder addFirstName(String firstName) {
        this.firstName=firstName;
        return this;
    }
    public PatientDtoBuilder addLastName(String lastName) {
        this.lastName=lastName;
        return this;
    }
    public PatientDtoBuilder addMiddleName(String middleName) {
        this.middleName=middleName;
        return this;
    }
    public PatientDtoBuilder addDob(Date dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
        return this;
    }
    public PatientDtoBuilder addGender(Gender gender) {
        this.gender=gender;
        return this;
    }
    public PatientDtoBuilder addBloodType(BloodType bloodType) {
        this.bloodType=bloodType;
        return this;
    }
    public PatientDtoBuilder addPhone(String phone) {
        this.phone=phone;
        return this;
    }
    public PatientDtoBuilder addEmail(String email) {
        this.email=email;
        return this;
    }
    public PatientDtoBuilder addAddress(String address) {
        this.address=address;
        return this;
    }
    public PatientDtoBuilder addCity(String cityName) {
        this.cityName=cityName;
        return this;
    }
    public PatientDtoBuilder addAllergies(String allergies) {
        this.allergies=allergies;
        return this;
    }
    
}
