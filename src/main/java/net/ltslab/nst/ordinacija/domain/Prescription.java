/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 *
 * @author bobanlukic
 */
@Embeddable
@Table(name = "prescription")
public class Prescription implements Serializable {

    private static final long serialVersionUID = -4275155193481902682L;

    @Column(name = "description")
    private String description;
    
    public Prescription() {
    }

 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.description);
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
        final Prescription other = (Prescription) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
       
        return true;
    }

}
