/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bobanlukic
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> { 
    
    public AppUser findByUsername(String username);
    
    public List<AppUser> findByActiveTrue();
    
    public List<AppUser> findByActiveFalse();
    

    public AppUser findByUsernameAndActiveTrue(String username);
    
    

    
}