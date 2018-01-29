/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import net.ltslab.nst.ordinacija.domain.enums.BloodType;
import net.ltslab.nst.ordinacija.domain.enums.Gender;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author bobanlukic
 */

@Entity
@Table(name = "patient")
@XmlRootElement
@Indexed
public class Patient implements Serializable {

    private static final long serialVersionUID = 3259832604765001001L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
    @Column(name = "first_name")
    private String firstName;
    
    @Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
    @Column(name = "middle_name")
    private String middleName;
    
    @Field(index=Index.YES,analyze=Analyze.YES,store=Store.NO)
    @Column(name = "last_name")
    private String lastName;
    
    @IndexedEmbedded
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private ContactInfo contactInfo;
    
    @Field(index=Index.YES,analyze=Analyze.YES,store=Store.YES)
    @Column(name = "dob")
    @DateBridge(resolution=Resolution.DAY)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(name = "blood_type")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    
    @Column(name = "allergies")
    private String allergies;
    
//    @ElementCollection(fetch = FetchType.EAGER, targetClass = Vitals.class)
    @OneToMany( mappedBy = "patient", cascade = CascadeType.ALL)
//    @OneToMany
    @Column(name = "vitals")
    private List<Vitals> vitals;

    public Patient() {
    }

    public Patient(String firstName, String middleName, String lastName, ContactInfo contactInfo, Date dateOfBirth, Gender gender, BloodType bloodType, String allergies, List<Vitals> vitals) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.vitals = vitals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
    
    public void addVitals(Vitals vitals){
        vitals.setPatient(this);
        getVitals().add(vitals);
    }
    
    public void removeVitals(Vitals vitals) {
        if (getVitals().contains(vitals)) {
            getVitals().remove(vitals);
        }
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
