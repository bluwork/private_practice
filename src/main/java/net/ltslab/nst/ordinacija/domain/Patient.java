/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import net.ltslab.nst.ordinacija.domain.enums.BloodType;
import net.ltslab.nst.ordinacija.domain.enums.Gender;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "patient")
@Indexed
public class Patient implements Serializable {

    private static final long serialVersionUID = 3259832604765001001L;

    @Id
    @Column(name = "id")
    private String id;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Column(name = "first_name")
    private String firstName;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Column(name = "middle_name")
    private String middleName;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Column(name = "last_name")
    private String lastName;

    @JoinColumn(name = "contact_info")
    @OneToOne(cascade = CascadeType.ALL)
    private ContactInfo contactInfo;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "blood_type")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column(name = "allergies")
    private String allergies;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @Column(name = "vitals")
    private List<Vitals> vitals;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @Column(name = "medical")
    private List<Medical> medicals;

    @Column(name = "soft_del")
    private boolean softDeleted;

    @Column(name = "date_added")
    private LocalDate dateAdded;

    public Patient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public List<Vitals> getVitals() {
        if (vitals == null) {
            vitals = new ArrayList<>();
        }
        return vitals;
    }

    public void setVitals(List<Vitals> vitals) {
        this.vitals = vitals;
    }

    public void addVitals(Vitals vitals) {
        vitals.setPatient(this);
        getVitals().add(vitals);
    }

    public void removeVitals(Vitals vitals) {
        if (getVitals().contains(vitals)) {
            getVitals().remove(vitals);
        }
    }

    public List<Medical> getMedicals() {
        if (medicals == null) {
            medicals = new ArrayList<>();
        }
        return medicals;
    }

    public void setMedicals(List<Medical> medicals) {
        this.medicals = medicals;
    }

    public void addMedical(Medical medical) {
        medical.setPatient(this);
        getMedicals().add(medical);
    }

    public void removeMedical(Medical medical) {
        if (getMedicals().contains(medical)) {
            getMedicals().remove(medical);
        }
    }

    public boolean isSoftDeleted() {
        return softDeleted;
    }

    public void setSoftDeleted(boolean softDeleted) {
        this.softDeleted = softDeleted;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.middleName);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        hash = 59 * hash + Objects.hashCode(this.allergies);
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
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender + ", bloodType=" + bloodType + '}';
    }

}
