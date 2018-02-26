/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.Vitals;

/**
 *
 * @author bobanlukic
 */
public interface VitalsService {

    List<Vitals> getAllVitals(Long patientId);

    Vitals getVitals(Long id);

    void addOrUpdateVitals(Vitals vitals);

    void deleteVitals(Long id);
}
