/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.dto.MedicalDto;

/**
 *
 * @author bobanlukic
 */
public interface MedicalService {

    void addOrUpdate(MedicalDto medicalDto);

    public MedicalDto getMedicalDto(HttpServletRequest request, Long patientId);
}
