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
public class PrescriptionDto implements Serializable{

    private static final long serialVersionUID = -1348658947549793689L;

    private Long locId;
    
    private String globalId;
    
    private AppUserDto prescriptioner;
    
    private PatientDto patient;
    
    private LocalDateTime createdDate;
    
    private String description;
    
    private boolean realized;

    public PrescriptionDto() {
    }

    public Long getLocId() {
        return locId;
    }

    public void setLocId(Long locId) {
        this.locId = locId;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public AppUserDto getPrescriptioner() {
        return prescriptioner;
    }

    public void setPrescriptioner(AppUserDto prescriptioner) {
        this.prescriptioner = prescriptioner;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRealized() {
        return realized;
    }

    public void setRealized(boolean realized) {
        this.realized = realized;
    }
    
    
}
