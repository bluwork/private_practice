/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author bobanlukic
 */
@Embeddable
@Table(name = "prescription")
@Data
public class Prescription implements Serializable {

    private static final long serialVersionUID = -4275155193481902682L;

    @Column(name = "description")
    private String description;
}
