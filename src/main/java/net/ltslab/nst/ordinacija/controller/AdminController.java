/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showUserForm(Model model) {
        model.addAttribute("new_user", new AppUserDto());
        return "/admin/add_user";
    }
     
    @RequestMapping(method=RequestMethod.POST, value="/admin/add_user")
    public String addUser(@ModelAttribute AppUserDto appUserDto, Model model) {
        AppUser appUser = Converter.convertDtoToEntity(appUserDto);
        
        if (appUserService.findByUsername(appUser.getUsername())== null) {
            appUserService.addOrUpdateUser(appUser);
            return "redirect:/admin/all_users";
        }
       
        appUserDto.setUsername(null);
        appUserDto.setPassword(null);
        
        model.addAttribute("new_user", appUserDto);
        model.addAttribute("username_exists", true);
        
        return "admin/add_user";
       
    }
    
    @RequestMapping("/admin/all_users")
    public String allUsers(Model model) {
        List<AppUser> allUsers = appUserService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "/admin/all_users";
    }
    
    @RequestMapping("/admin/all_cities")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "all_cities";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/admin/delete_user")
    public String deletePatient(@RequestParam(name="id") Long userId) {
        appUserService.deleteAppUser(userId);
        System.out.println(" " + userId);
        return "redirect:/admin/all_users";
    }
}
