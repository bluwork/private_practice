/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bobanlukic
 */
public class AppointmentDto implements Serializable {

    private static final long serialVersionUID = 5640076433653943319L;

    private Long id;
    
    private AppUserDto doctor;
    
    private PatientDto patient;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    
    private LocalTime time;
    
    private int part;

    public AppointmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUserDto getDoctor() {
        return doctor;
    }

    public void setDoctor(AppUserDto doctor) {
        this.doctor = doctor;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

 }
