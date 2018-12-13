/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.dto.AppUserDto;

/**
 *
 * @author bobanlukic
 */
public interface AppUserService {

    AppUserDto findByUsername(String username);

    AppUserDto findActiveByUsername(String username);

    AppUserDto getById(Long id);

    AppUserDto getDoctorDto(HttpServletRequest request);

    AppUser getDoctor(HttpServletRequest request);

    List<AppUserDto> getAllUsers();

    List<AppUserDto> getAllActiveUsers();

    List<AppUserDto> getAllActiveDoctors();

    List<AppUserDto> getAllSuspendedUsers();

    void updateUser(AppUserDto appUserDto);

    void reactivateUser(Long appUserId);

    boolean suspendUser(Long appUserId);

    boolean addAppUser(AppUserDto appUserDto);

}
