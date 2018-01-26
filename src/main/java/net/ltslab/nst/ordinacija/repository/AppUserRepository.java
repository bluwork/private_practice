/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.repository;

import net.ltslab.nst.ordinacija.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bobanlukic
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

    @Query("SELECT au FROM AppUser au WHERE username = ?1")
    public AppUser findByUsername(String username);
    
}
