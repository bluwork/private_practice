/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dto;

import java.io.Serializable;

/**
 *
 * @author bobanlukic
 */
public class CityDto implements Serializable {

    private static final long serialVersionUID = -7814489997857919935L;

    private Long zipCode;

    private String name;

    public CityDto() {
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
