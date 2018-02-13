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
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author bobanlukic
 */

@Entity
@Table(name = "medical")
public class Medical implements Serializable{

    private static final long serialVersionUID = 2286905328752799229L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private AppUser doctor;
    

    @Column(name = "medical_date") 
    private LocalDateTime medicalDate;
   
    @Lob
    @Column(name = "description")
    private String description;
    
    @Column(name = "diagnosis")
    private String diagnosis;
    
    @Column(name = "therapy")
    private String therapy;
    
    @OneToMany( mappedBy = "medical", cascade = CascadeType.ALL)
    @Column(name = "requests")
    private List<Request> requests;
    
    @OneToMany( mappedBy = "medical", cascade = CascadeType.ALL)
    @Column(name = "results")
    private List<Result> previousResults;
    
    @OneToMany( mappedBy = "medical", cascade = CascadeType.ALL)
    @Column(name = "receipts")
    private List<Receipt> receipts;

    public Medical() {
        
    }

    public Medical(Patient patient, AppUser doctor, LocalDateTime medicalDate, String description, String diagnosis, String therapy, List<Request> requests, List<Result> previousResults) {
        this.patient = patient;
        this.doctor = doctor;
        this.medicalDate = medicalDate;
        this.description = description;
        this.diagnosis = diagnosis;
        this.therapy = therapy;
        this.requests = requests;
        this.previousResults = previousResults;
    }

    public Medical(Patient patient, AppUser doctor, LocalDateTime medicalDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.medicalDate = medicalDate;
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

    public AppUser getDoctor() {
        return doctor;
    }

    public void setDoctor(AppUser doctor) {
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

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
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

    public List<Request> getRequests() {
        if (requests == null) {
            requests = new ArrayList<>();
        }
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Result> getPreviousResults() {
        if (previousResults == null) {
            previousResults = new ArrayList<>();
        }
        return previousResults;
    }

    public void setPreviousResults(List<Result> previousResults) {
        this.previousResults = previousResults;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.patient);
        hash = 79 * hash + Objects.hashCode(this.doctor);
        hash = 79 * hash + Objects.hashCode(this.medicalDate);
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
        final Medical other = (Medical) obj;
        if (!Objects.equals(this.patient, other.patient)) {
            return false;
        }
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }
        return Objects.equals(this.medicalDate, other.medicalDate);
    }
    
    
    
}
