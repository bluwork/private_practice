/*     Copyright (c) Boban Lukic. All rights reserved.
 *     The use and distribution terms for this software are covered by the
 *     Eclipse Public License 1.0 (http://www.eclipse.org/legal/epl-v10.html) or later
 *     which can be found in the file LICENSE at the root of this distribution.
 *     By using this software in any fashion, you are agreeing to be bound by
 *     the terms of this license.
 *     You must not remove this notice, or any other, from this software.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bobanlukic
 */

@Entity
@Table(name = "vitals")
@XmlRootElement
public class Vitals implements Serializable {

    private static final long serialVersionUID = -1821040339771336496L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    @Column(name = "measuring_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date measuringDate;
    
    @Column(name = "diastolic_bp")
    private Integer diastolicBP;
    
    @Column(name = "systolic_bp")
    private Integer systolicBP;
    
    @Column(name = "body_temp")
    private Float bodyTemp;
    
    @Column(name = "heart_rate")
    private Integer heartRate;
    
    @Column(name = "height")
    private Integer height;
    
    @Column(name = "mass")
    private Integer mass;
    
     public Vitals() {
        
    }

    public Vitals(Date measuringDate, Integer diastolicBP, Integer systolicBP, Float bodyTemp, Integer heartRate, Integer height, Integer mass) {
        
        this.measuringDate = measuringDate;
        this.diastolicBP = diastolicBP;
        this.systolicBP = systolicBP;
        this.bodyTemp = bodyTemp;
        this.heartRate = heartRate;
        this.height = height;
        this.mass = mass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getMeasuringDate() {
        return measuringDate;
    }

    public void setMeasuringDate(Date measuringDate) {
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
    
   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.patient);
        hash = 79 * hash + Objects.hashCode(this.measuringDate);
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
        final Vitals other = (Vitals) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vitals{" + "id=" + id + ", patient=" + patient + ", measuringDate=" + measuringDate + ", diastolicBP=" + diastolicBP + ", systolicBP=" + systolicBP + ", bodyTemp=" + bodyTemp + ", heartRate=" + heartRate + ", height=" + height + ", mass=" + mass + '}';
    }

    
    
    
}
