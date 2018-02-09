/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import net.ltslab.nst.ordinacija.domain.Medical;
import net.ltslab.nst.ordinacija.repository.MedicalRepository;
import net.ltslab.nst.ordinacija.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class MedicalServiceImpl implements MedicalService{

    @Autowired
    MedicalRepository medicalRepository;
    
    @Override
    public void addOrUpdate(Medical medical) {
        medicalRepository.save(medical);
    }
    
}
