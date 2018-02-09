/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;

/**
 *
 * @author bobanlukic
 */

public interface AppUserService {
    
    AppUser findByUsername(String username);

    public void addOrUpdateUser(AppUser appUser);

    public List<AppUser> getAllUsers();

    public void deleteAppUser(Long userId);
}
