/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 *
 * @author bobanlukic
 */
public class MedicalDto implements Serializable {

    private static final long serialVersionUID = -1577012060077782847L;

    private Long id;

    private PatientDto patient;
  
    private AppUserDto doctor;

    private LocalDateTime medicalDate;

    private String description;

    private String diagnosis;

    private String therapy;

    public MedicalDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public AppUserDto getDoctor() {
        return doctor;
    }

    public void setDoctor(AppUserDto doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getMedicalDate() {
        return medicalDate;
    }

    public void setMedicalDate(LocalDateTime medicalDate) {
        this.medicalDate = medicalDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

}
