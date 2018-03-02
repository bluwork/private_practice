/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.util;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.City;
import net.ltslab.nst.ordinacija.dto.CityDto;
import org.mapstruct.Mapper;

/**
 *
 * @author bobanlukic
 */
@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDto cityToCityDto(City city);

    City cityDtoToCity(CityDto cityDto);

    List<CityDto> citiesToCityDtos(List<City> cities);
}
