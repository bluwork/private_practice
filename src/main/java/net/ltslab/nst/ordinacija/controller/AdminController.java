/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.CityDto;
import net.ltslab.nst.ordinacija.dto.DiagnosisDto;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/admin/add_city")
    public String addCity(Model model) {
        model.addAttribute("city", new CityDto());
        return "/admin/add_city";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/add_city")
    public String saveCity(@ModelAttribute CityDto cityDto, Model model) {

        if (ordinacijaFacade.addCity(cityDto)) {
            return "redirect:/admin/all_cities";
        }
        cityDto.setZipCode(null);
        model.addAttribute("city", cityDto);
        model.addAttribute("zip_code_exists", true);

        return "admin/add_city";

    }

    @RequestMapping("/admin/update_city/{zip_code}")
    public String showUpdateCity(@PathVariable(name = "zip_code") Long zipCode, Model model) {
        model.addAttribute("city", ordinacijaFacade.getCityDto(zipCode));
        return "/admin/update_city";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/update_city")
    public String updateCity(@ModelAttribute CityDto cityDto, Model model) {

        ordinacijaFacade.updateCity(cityDto);
        return "redirect:/admin/all_cities";

    }

    @RequestMapping("/admin/add_diagnosis")
    public String addDiagnosis(Model model) {
        model.addAttribute("diagnosis", new DiagnosisDto());
        return "/admin/add_diagnosis";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/add_diagnosis")
    public String saveDiagnosis(@ModelAttribute DiagnosisDto diagnosisDto, Model model) {

        if (ordinacijaFacade.addDiagnosis(diagnosisDto)) {
            return "redirect:/admin/all_diagnoses";
        }
        diagnosisDto.setCode(null);
        model.addAttribute("city", diagnosisDto);
        model.addAttribute("diagnosis_code_exists", true);

        return "admin/add_diagnosis";

    }

    @RequestMapping("/admin/update_diagnosis/{code}")
    public String showUpdateDiagnosis(@PathVariable(name = "code") String code, Model model) {
        model.addAttribute("diagnosis", ordinacijaFacade.getDiagnosisDto(code));
        return "/admin/update_diagnosis";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/update_diagnosis")
    public String updateDiagnosis(@ModelAttribute DiagnosisDto diagnosisDto, Model model) {

        ordinacijaFacade.updateDiagnosis(diagnosisDto);
        return "redirect:/admin/all_diagnoses";

    }

    @RequestMapping("/admin/update_user/{id}")
    public String showUpdateUser(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("user", ordinacijaFacade.getAppUserDto(id));
        return "/admin/update_user";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/update_user")
    public String updateUser(@ModelAttribute AppUserDto appUserDto, Model model) {

        ordinacijaFacade.updateUser(appUserDto);
        return "redirect:/admin/all_users";

    }

    @RequestMapping("/admin/all_users")
    public String allUsers(Model model) {

        model.addAttribute("users", ordinacijaFacade.getAllUsers());
        return "/admin/all_users";
    }

    @RequestMapping("/admin/all_cities")
    public String page(Model model) {
        model.addAttribute("cities", ordinacijaFacade.getAllCities());
        return "/admin/all_cities";
    }

    @RequestMapping("/admin/all_diagnoses")
    public String allDiagnoses(Model model) {
        model.addAttribute("diagnoses", ordinacijaFacade.getDiagnoses());
        return "/admin/all_diagnoses";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/suspend_user")
    public String suspendUser(@RequestParam(name = "id") Long appUserId, RedirectAttributes ra) {

        if (!ordinacijaFacade.suspendUser(appUserId)) {
            ra.addFlashAttribute("message", "One admin must be active. Operation aborted.");
        }

        return "redirect:/admin/all_users";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/reactivate_user")
    public String reactivateUser(@RequestParam(name = "id") Long appUserId) {

        ordinacijaFacade.reactivateUser(appUserId);
        return "redirect:/admin/all_users";
    }

    @RequestMapping("/admin/all_patients")
    public String allPatients(Model model) {
        model.addAttribute("patients", ordinacijaFacade.getAllActivePatients());
        return "/admin/all_patients";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/delete_patient/{id}")
    public String deletePatient(@PathVariable(name = "id") String patientId, RedirectAttributes ra) {

        ordinacijaFacade.softDeletePatient(patientId);
        ra.addFlashAttribute("deleted", "" + patientId);
        return "redirect:/admin/all_patients";
    }

    @RequestMapping("/admin/import_users")
    public String importUsers(Model model) {

        return "/admin/import_users";
    }
}
