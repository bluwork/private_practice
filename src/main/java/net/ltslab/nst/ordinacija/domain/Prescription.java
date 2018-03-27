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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "prescription")
public class Prescription implements Serializable{
    
    private static final long serialVersionUID = -4275155193481902682L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
    private Long locId;
    
    @Column(name = "global_id")
    private String globalId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prescriptioner_id")
    private AppUser prescriptioner;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    @Column(name = "creation_date")
    private LocalDateTime createdDate;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "realized")
    private boolean realized;

    public Prescription() {
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

    public AppUser getPrescriptioner() {
        return prescriptioner;
    }

    public void setPrescriptioner(AppUser prescriptioner) {
        this.prescriptioner = prescriptioner;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.globalId);
        hash = 53 * hash + Objects.hashCode(this.prescriptioner);
        hash = 53 * hash + Objects.hashCode(this.patient);
        hash = 53 * hash + Objects.hashCode(this.createdDate);
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
        final Prescription other = (Prescription) obj;
        if (!Objects.equals(this.globalId, other.globalId)) {
            return false;
        }
        if (!Objects.equals(this.prescriptioner, other.prescriptioner)) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        if (!Objects.equals(this.createdDate, other.createdDate)) {
            return false;
        }
        return true;
    }
      
}
