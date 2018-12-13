/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.List;
import net.ltslab.nst.ordinacija.dto.CityDto;

/**
 *
 * @author bobanlukic
 */
public interface CityService {

    List<CityDto> allCities();

    CityDto getCityByZipCode(Long zipCode);

    boolean addCity(CityDto cityDto);

    public void updateCity(CityDto cityDto);
}
