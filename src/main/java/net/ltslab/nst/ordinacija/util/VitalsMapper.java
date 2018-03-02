/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.util;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Vitals;
import net.ltslab.nst.ordinacija.dto.VitalsDto;
import org.mapstruct.Mapper;

/**
 *
 * @author bobanlukic
 */
@Mapper(componentModel = "spring")
public interface VitalsMapper {

    VitalsDto vitalsToVitalsDto(Vitals vitals);

    Vitals vitalsDtoToVitals(VitalsDto vitalsDto);

    List<VitalsDto> vitalsToVitalsDtos(List<Vitals> vitals);
    
    
}
