/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
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
import lombok.Data;
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
@Data
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

}
