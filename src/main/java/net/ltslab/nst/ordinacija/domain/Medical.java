package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "medical")
@Data
public class Medical implements Serializable {

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

    @JoinColumn(name = "diagnosis")
    @ManyToOne(fetch = FetchType.EAGER)
    private Diagnosis diagnosis;

    @Column(name = "therapy")
    private String therapy;

    @ElementCollection
    @CollectionTable(
            name = "prescription",
            joinColumns = @JoinColumn(name = "medical_id"))
    private List<Prescription> prescriptions;

}
