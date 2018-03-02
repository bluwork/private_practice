/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author bobanlukic
 */
public class VitalsDto implements Serializable {

    private static final long serialVersionUID = 6301172402011702562L;

    private PatientDto patient;

    private LocalDate measuringDate;

    private Integer diastolicBP;

    private Integer systolicBP;

    private Float bodyTemp;

    private Integer heartRate;

    private Integer height;

    private Integer mass;

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public LocalDate getMeasuringDate() {
        return measuringDate;
    }

    public void setMeasuringDate(LocalDate measuringDate) {
        this.measuringDate = measuringDate;
    }

    public Integer getDiastolicBP() {
        return diastolicBP;
    }

    public void setDiastolicBP(Integer diastolicBP) {
        this.diastolicBP = diastolicBP;
    }

    public Integer getSystolicBP() {
        return systolicBP;
    }

    public void setSystolicBP(Integer systolicBP) {
        this.systolicBP = systolicBP;
    }

    public Float getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(Float bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }
    
    
}
