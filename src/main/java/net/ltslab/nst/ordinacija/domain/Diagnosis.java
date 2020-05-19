/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "diagnosis")
@Data
public class Diagnosis implements Serializable {

    private static final long serialVersionUID = -1505893885601213150L;

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

}
