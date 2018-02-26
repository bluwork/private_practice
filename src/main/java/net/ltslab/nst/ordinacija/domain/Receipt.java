/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bobanlukic
 */
@Entity
@XmlRootElement
public class Receipt implements Serializable {

    private static final long serialVersionUID = 7973663816218031719L;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medical_id")
    private Medical medical;

    @Column(name = "description")
    private String description;

    public Receipt() {
    }

    public Receipt(AppUser doctor, Patient patient, String description) {
        this.doctor = doctor;
        this.patient = patient;
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.patient);
        hash = 89 * hash + Objects.hashCode(this.doctor);
        hash = 89 * hash + Objects.hashCode(this.description);
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
        final Receipt other = (Receipt) obj;
        return Objects.equals(this.id, other.id);
    }

}
