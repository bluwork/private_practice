/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.Receipt;
import net.ltslab.nst.ordinacija.domain.Request;
import net.ltslab.nst.ordinacija.domain.Result;

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

    private List<Request> requests;

    private List<Result> previousResults;

    private List<Receipt> receipts;

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

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Result> getPreviousResults() {
        return previousResults;
    }

    public void setPreviousResults(List<Result> previousResults) {
        this.previousResults = previousResults;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }
}
