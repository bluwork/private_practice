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
@Table(name = "city")
@Data
public class City implements Serializable {

    private static final long serialVersionUID = -6955787543314268955L;

    @Id
    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "name")
    private String name;

}
