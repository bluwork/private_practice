/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private String phone;
    private String email;
    private String address;
    private String cityName;
    private String allergies;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate medScheduleDate;
    
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime medScheduleTime;

    public PatientDto() {
    }

    public PatientDto(Long id, String firstName, String lastName, String middleName, LocalDate dateOfBirth, Gender gender, BloodType bloodType, String phone, String email, String address, String cityName, String allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodType = bloodType;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cityName = cityName;
        this.allergies = allergies;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public LocalDate getMedScheduleDate() {
        return medScheduleDate;
    }

    public void setMedScheduleDate(LocalDate medScheduleDate) {
        this.medScheduleDate = medScheduleDate;
    }

    public LocalTime getMedScheduleTime() {
        return medScheduleTime;
    }

    public void setMedScheduleTime(LocalTime medScheduleTime) {
        this.medScheduleTime = medScheduleTime;
    }
    
    
    
}
