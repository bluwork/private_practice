/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    OrdinacijaFacade ordinacijaFacade;

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/admin/add_user")
    public String showUserForm(Model model) {
        model.addAttribute("new_user", new AppUserDto());
        return "/admin/add_user";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/add_user")
    public String addUser(@ModelAttribute AppUserDto appUserDto, Model model) {

        if (ordinacijaFacade.addAppUser(appUserDto)) {

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

        model.addAttribute("users", ordinacijaFacade.getAllUsers());
        return "/admin/all_users";
    }

    @RequestMapping("/admin/all_cities")
    public String page(Model model) {
        return "all_cities";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/delete_user")
    public String deleteUser(@RequestParam(name = "id") Long appUserId) {

        ordinacijaFacade.deleteAppUser(appUserId);
        return "redirect:/admin/all_users";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/suspend_user")
    public String suspendUser(@RequestParam(name = "id") Long appUserId) {

        ordinacijaFacade.suspendUser(appUserId);
        return "redirect:/admin/all_users";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/reactivate_user")
    public String reactivateUser(@RequestParam(name = "id") Long appUserId) {

        ordinacijaFacade.reactivateUser(appUserId);
        return "redirect:/admin/all_users";
    }
}
