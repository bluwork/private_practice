/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author bobanlukic
 */
@Entity
public class Appointment implements Serializable{

    private static final long serialVersionUID = -6741529452052740160L;
    
    @Id
    private Long id;
    
    @Column(name = "doctor_id")
    private AppUser doctor;
    
    @Column(name = "patient_id")
    private Patient patient;
    
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getDoctor() {
        return doctor;
    }

    public void setDoctor(AppUser doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDate(LocalDateTime date) {
        this.dateTime = dateTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.doctor);
        hash = 37 * hash + Objects.hashCode(this.patient);
        hash = 37 * hash + Objects.hashCode(this.dateTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        return true;
    }

}
