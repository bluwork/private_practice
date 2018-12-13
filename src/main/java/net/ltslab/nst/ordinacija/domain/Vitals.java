package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "vitals")
public class Vitals implements Serializable {

    private static final long serialVersionUID = -1821040339771336496L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "measuring_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate measuringDate;

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

}
