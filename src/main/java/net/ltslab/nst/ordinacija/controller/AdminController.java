/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.enums.Role;
import net.ltslab.nst.ordinacija.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bobanlukic
 */

@Controller
public class AdminController {
       
    @Autowired
    AppUserService appUserService;
    
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
    
    @RequestMapping("/admin/add_user")
    public String addNewPatient(Model model) {
        model.addAttribute("new_user", new AppUser());
        model.addAttribute("roles", Role.values());
        return "/admin/add_user";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/admin/new_user")
    public void addUser(@ModelAttribute AppUser appUser, Model model) {
        appUserService.addOrUpdateUser(appUser);
        model.addAttribute("new_user_name", appUser.getFirstName());
    }
}
