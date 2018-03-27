/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.List;
import net.ltslab.nst.ordinacija.dto.VitalsDto;

/**
 *
 * @author bobanlukic
 */
public interface VitalsService {

    List<VitalsDto> getAllVitals(String patientId);

    VitalsDto getVitalsDto(String patientId);

    void addOrUpdateVitals(VitalsDto vitals);

    void deleteVitals(Long id);
}
