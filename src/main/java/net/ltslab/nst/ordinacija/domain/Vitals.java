package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "vitals")
@Data
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

}
