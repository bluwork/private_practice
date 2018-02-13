/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service("appUserDetailsService")
public class AppUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findActiveByUsername(username);
        
        if (appUser == null) {
            throw new UsernameNotFoundException("Invalid or not active username: " + username);
        }
        
        return buildUser(appUser);
    }
    

    private UserDetails buildUser(AppUser appUser) {
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach((role) -> {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        });   
        
        return new User(appUser.getUsername(), appUser.getPassword(), true, true, true, true, authorities);
    }
}
