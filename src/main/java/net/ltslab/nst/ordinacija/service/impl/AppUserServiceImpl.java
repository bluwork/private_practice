/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.enums.Role;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.ltslab.nst.ordinacija.repository.AppUserRepository;
import net.ltslab.nst.ordinacija.util.DtoConverter;

/**
 *
 * @author bobanlukic
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addOrUpdateUser(AppUser appUser) {
        appUserRepository.saveAndFlush(appUser);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public void deleteAppUser(Long userId) {
        appUserRepository.delete(userId);
    }

    @Override
    public List<AppUser> getAllActiveUsers() {
        return appUserRepository.findByActiveTrue();
    }

    @Override
    public List<AppUser> getAllSuspendedUsers() {
        return appUserRepository.findByActiveFalse();
    }

    @Override
    public void suspendUser(Long appUserId) {
        AppUser suspendedUser = appUserRepository.findOne(appUserId);
        suspendedUser.setActive(false);
        appUserRepository.saveAndFlush(suspendedUser);
    }

    @Override
    public void reactivateUser(Long appUserId) {
        AppUser activatedUser = appUserRepository.findOne(appUserId);
        activatedUser.setActive(true);
        appUserRepository.saveAndFlush(activatedUser);
    }

    @Override
    public AppUser findActiveByUsername(String username) {
        return appUserRepository.findByUsernameAndActiveTrue(username);
    }

    @Override
    public List<AppUser> getAllActiveDoctors() {
        
        List<AppUser> availableDoctors = new ArrayList<>();

        for (AppUser user : getAllActiveUsers()) {
            if (user.getRoles().contains(Role.DOCTOR)) {
                availableDoctors.add(user);
            }
        }
        return availableDoctors;
    }

    @Override
    public boolean addAppUser(AppUserDto appUserDto) {
        AppUser appUser = DtoConverter.convertDtoToEntity(appUserDto);
        if (findByUsername(appUser.getUsername()) == null) {
            addOrUpdateUser(appUser);
            return true;
        }
        return false;
    }

    @Override
    public AppUser getDoctor(HttpServletRequest request) {
        return findByUsername(request.getUserPrincipal().getName());
    }

}
