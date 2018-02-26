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

    AppUser findActiveByUsername(String username);

    List<AppUser> getAllUsers();

    List<AppUser> getAllActiveUsers();

    List<AppUser> getAllSuspendedUsers();
    
    void addOrUpdateUser(AppUser appUser);

    void suspendUser(Long appUserId);

    void reactivateUser(Long appUserId);

    void deleteAppUser(Long userId);
}
