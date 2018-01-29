/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import net.ltslab.nst.ordinacija.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bobanlukic
 */

public interface AppUserRepository extends JpaRepository<AppUser, Long> { 
    
    public AppUser findByUsername(String username);   
    
}