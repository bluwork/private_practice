/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.dao;

import net.ltslab.nst.ordinacija.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bobanlukic
 */
@Repository
public interface AppUserDao extends JpaRepository<AppUser, Long> { 
    
    public AppUser findByUsername(String username);   
    
}