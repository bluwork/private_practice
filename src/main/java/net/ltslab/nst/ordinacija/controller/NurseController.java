/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.dto.VitalsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import net.ltslab.nst.ordinacija.util.Slot;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bobanlukic
 */
@Controller
public class NurseController {

    //TODO Ovo ubaciti u properties
    public static final int START_HOUR = 7;
    public static final int FINAL_HOUR = 17;
    public static final int SLOTS_IN_HOUR = 3;

    @Autowired
    OrdinacijaFacade ordinacijaFacade;

    @RequestMapping("/nurse")
    public String nurse(Model model) {
        model.addAttribute("patients", ordinacijaFacade.getAllScheduledPatients(LocalDate.now()));
        return "nurse";
    }

    @RequestMapping("/nurse/add_patient")
    public String addNewPatient(Model model) {
        model.addAttribute("patient", new PatientDto());
        model.addAttribute("cities", ordinacijaFacade.getAllCities());
        return "/nurse/add_patient";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/add_patient")
    public String addNewPatient(@ModelAttribute PatientDto patientDto, Model model, RedirectAttributes ra) {

        if (ordinacijaFacade.addPatient(patientDto)) {
            ra.addFlashAttribute("added_patient", patientDto);
            ordinacijaFacade.sendEmail(patientDto, "Welcome to Ordinacija", "Welcome to our private practice. King regards, Ordinacija.");
            return "redirect:/nurse";
        }
        model.addAttribute("patient", patientDto);
        model.addAttribute("cities", ordinacijaFacade.getAllCities());
        model.addAttribute("patient_id_exists", true);
        return "/nurse/add_patient";

    }

    @RequestMapping("/nurse/search_results")
    public String search(@RequestParam String searchText, Model model, RedirectAttributes ra) {

        List<PatientDto> searchResult = ordinacijaFacade.searchFor(searchText);
        
        if (searchResult != null) {
            if (!searchResult.isEmpty()) {
                model.addAttribute("patients", ordinacijaFacade.searchFor(searchText));
                return "/nurse/search_results";
            }
        }
        ra.addFlashAttribute("zero_res", true);
        return "redirect:/nurse";
        
    }

    @RequestMapping("/nurse/check_appointments/{id}")
    public String checkAppointments(@PathVariable(name = "id") Long patientId, Model model) {

        AppointmentDto appDto = ordinacijaFacade.getAppointmentDto();
        PatientDto patientDto = ordinacijaFacade.getPatientDto(patientId);
        appDto.setPatient(patientDto);

        model.addAttribute("appointment", appDto);

        model.addAttribute("doctors", ordinacijaFacade.getAllActiveDoctors());

        return "/nurse/check_appointments";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/check_appointments")
    public String getAllAppointments(@ModelAttribute AppointmentDto appointmentDto, RedirectAttributes ra) {

        ra.addFlashAttribute("appointment", appointmentDto);

        return "redirect:/nurse/add_appointment";
    }

    @RequestMapping("/nurse/add_appointment")
    public String addAppointment(Model model) {

        AppointmentDto appDto = (AppointmentDto) model.asMap().get("appointment");
        List<Slot> allSlots = generateSlots(appDto.getDate());

        for (AppointmentDto a : ordinacijaFacade.getAllAppointmentDtos(appDto.getDate(), appDto.getDoctor())) {

            Slot s = new Slot();
            s.setDate(a.getDate());
            s.setTime(a.getTime());
            s.setPartNumber(a.getPart());

            if (allSlots.contains(s)) {
                allSlots.get(allSlots.indexOf(s)).setOccupied(true);
            }

        }

        model.addAttribute("slots", allSlots);
        model.addAttribute("slot_value", 60 / SLOTS_IN_HOUR);

        return "/nurse/add_appointment";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/add_appointment")
    public String saveAppointment(@ModelAttribute AppointmentDto appointmentDto, RedirectAttributes ra,
            @RequestParam(name = "d") String date, @RequestParam(name = "t") String time, @RequestParam(name = "p") int part) {
        appointmentDto.setDate(LocalDate.parse(date));
        appointmentDto.setTime(LocalTime.parse(time));
        appointmentDto.setPart(part);
        ordinacijaFacade.addAppointment(appointmentDto);
        ra.addFlashAttribute("appointment_added", true);
        return "redirect:/nurse";
    }

    @RequestMapping("/nurse/add_vitals/{id}")
    public String addVitals(@PathVariable(name = "id") Long patientId, Model model) {
        model.addAttribute("vitals", ordinacijaFacade.getVitals(patientId));
        return "/nurse/add_vitals";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/add_vitals")
    public String postVitals(@ModelAttribute VitalsDto vitals, RedirectAttributes ra) {

        ordinacijaFacade.saveVitals(vitals);
        ra.addFlashAttribute("vitals_added", true);

        return "redirect:/nurse";
    }

    private List<Slot> generateSlots(LocalDate date) {
        List<Slot> slots = new ArrayList<>();
        int allSlotsNum = (FINAL_HOUR - START_HOUR) * SLOTS_IN_HOUR;
        int everySlot = 0;
        int nextHour = START_HOUR;

        for (int k = 0; k < allSlotsNum; k++) {
            Slot s = new Slot();
            s.setDate(date);
            s.setTime(LocalTime.of(nextHour, 0));
            everySlot++;
            s.setPartNumber(everySlot - 1);
            if (everySlot == SLOTS_IN_HOUR) {
                everySlot = 0;
                nextHour++;
            }
            slots.add(s);
        }

        return slots;
    }
}
