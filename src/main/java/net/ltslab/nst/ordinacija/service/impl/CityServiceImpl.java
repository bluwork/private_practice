/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.City;
import net.ltslab.nst.ordinacija.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.ltslab.nst.ordinacija.repository.CityRepository;

/**
 *
 * @author bobanlukic
 */
@Service
public class CityServiceImpl implements CityService {
    
    @Autowired 
    CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void addOrUpdateCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.delete(id);
    }

    
}
