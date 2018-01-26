/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.repository.AppUserRepository;
import net.ltslab.nst.ordinacija.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
    
}
