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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author bobanlukic
 */

@Entity
public class Vitals implements Serializable {

    private static final long serialVersionUID = -1821040339771336496L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId")
    private Patient patient;
    
    @Column(name = "measuringDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date measuringDate;
    
    @Column(name = "diastolicBP")
    private Integer diastolicBP;
    
    @Column(name = "systolicBP")
    private Integer systolicBP;
    
    @Column(name = "bodyTemp")
    private Float bodyTemp;
    
    @Column(name = "heartRate")
    private Integer heartRate;
    
    @Column(name = "height")
    private Integer height;
    
    @Column(name = "mass")
    private Integer mass;

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
    
    public Vitals() {
        
    }

    public Vitals(Patient patient, Date measuringDate, Integer diastolicBP, Integer systolicBP, Float bodyTemp, Integer heartRate, Integer height, Integer mass) {
        this.patient = patient;
        this.measuringDate = measuringDate;
        this.diastolicBP = diastolicBP;
        this.systolicBP = systolicBP;
        this.bodyTemp = bodyTemp;
        this.heartRate = heartRate;
        this.height = height;
        this.mass = mass;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
