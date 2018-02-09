/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author bobanlukic
 */
@Entity
@DiscriminatorValue("img")
public class ImagingResult extends Result{
   
    private static final long serialVersionUID = 3960972877233745963L;
   
    
}
