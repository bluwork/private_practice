/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author bobanlukic
 */
@Entity
@DiscriminatorValue("spec")
public class SpecialistResult extends Result {

    private static final long serialVersionUID = 1244504993834281947L;

    @Column(name = "spec_res")
    private String specResult;

    public String getSpecResult() {
        return specResult;
    }

    public void setSpecResult(String specResult) {
        this.specResult = specResult;
    }

}
