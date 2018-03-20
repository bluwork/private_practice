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
import net.ltslab.nst.ordinacija.mapping.AppUserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author bobanlukic
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserMapper appUserMapper;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public AppUserDto findByUsername(String username) {
        return appUserMapper.appUserToAppUserDto(appUserRepository.findByUsername(username));
    }

    @Override
    public List<AppUserDto> getAllUsers() {
        List<AppUserDto> userDtos = new ArrayList<>();
        for (AppUser au : appUserRepository.findAll()) {
            userDtos.add(appUserMapper.appUserToAppUserDto(au));
        }
        return userDtos;
    }
    
    @Override
    public List<AppUserDto> getAllActiveUsers() {
        List<AppUserDto> activeUsersDtos = new ArrayList<>();

        for (AppUser active : appUserRepository.findByActiveTrue()) {
            activeUsersDtos.add(appUserMapper.appUserToAppUserDto(active));
        }
        return activeUsersDtos;
    }

    @Override
    public List<AppUserDto> getAllSuspendedUsers() {
        List<AppUserDto> suspendedUsersDtos = new ArrayList<>();

        for (AppUser suspended : appUserRepository.findByActiveFalse()) {
            suspendedUsersDtos.add(appUserMapper.appUserToAppUserDto(suspended));
        }
        return suspendedUsersDtos;
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
    public AppUserDto findActiveByUsername(String username) {
        return appUserMapper.appUserToAppUserDto(appUserRepository.findByUsernameAndActiveTrue(username));
    }

    @Override
    public List<AppUserDto> getAllActiveDoctors() {

        List<AppUserDto> availableDoctors = new ArrayList<>();

        for (AppUser user : appUserRepository.findByActiveTrue()) {
            if (user.getRoles().contains(Role.DOCTOR)) {
                availableDoctors.add(appUserMapper.appUserToAppUserDto(user));
            }
        }
        return availableDoctors;
    }

    @Override
    public boolean addAppUser(AppUserDto appUserDto) {
        AppUser appUser = appUserMapper.appUserDtoToAppUser(appUserDto);
        if (findByUsername(appUser.getUsername()) == null) {
            appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
            appUser.setActive(true);
            appUserRepository.saveAndFlush(appUser);
            return true;
        }
        return false;
    }

    @Override
    public AppUserDto getDoctor(HttpServletRequest request) {
        return findByUsername(request.getUserPrincipal().getName());
    }

    @Override
    public AppUserDto getById(Long id) {
        return appUserMapper.appUserToAppUserDto(appUserRepository.findOne(id));
    }

    @Override
    public void updateUser(AppUserDto appUserDto) {
        
        AppUser appUser = appUserMapper.appUserDtoToAppUser(appUserDto);
        appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
        appUserRepository.saveAndFlush(appUser);
    }

}
