/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Long id;
       
}
