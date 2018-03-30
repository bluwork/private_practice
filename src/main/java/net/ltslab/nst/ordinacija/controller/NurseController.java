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
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.dto.VitalsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import net.ltslab.nst.ordinacija.util.Slot;
import org.springframework.web.bind.annotation.PathVariable;
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
    public static final int SLOTS_IN_HOUR = 4;

    @Autowired
    OrdinacijaFacade ordinacijaFacade;

    @RequestMapping("/nurse")
    public String nurse(Model model) {
        model.addAttribute("patients", ordinacijaFacade.getAllScheduledPatients(LocalDate.now()));
        model.addAttribute("today_added", ordinacijaFacade.getAllPatientsAddedByDate(LocalDate.now()));
        model.addAttribute("finished", ordinacijaFacade.getAllFinishedPatients(LocalDate.now()));
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

        patientDto.setDateAdded(LocalDate.now());

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
    
    @RequestMapping("/nurse/update_patient/{id}")
    public String preparePatientUpdate(@PathVariable(name = "id") String patientId, Model model) {
        
        model.addAttribute("patient", ordinacijaFacade.getPatientDto(patientId));
        model.addAttribute("cities", ordinacijaFacade.getAllCities());
        return "/nurse/update_patient";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/update_patient")
    public String updatePatient(@ModelAttribute PatientDto patientDto, RedirectAttributes ra) {
        
        ordinacijaFacade.updatePatient(patientDto);
        ra.addFlashAttribute("patient_updated", patientDto);
        return "redirect:/nurse";
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

    @RequestMapping(value = "/nurse/add_appointment")
    public String checkAppointments(HttpServletRequest request, Model model) {

        Map<String, String[]> paramMap = request.getParameterMap();

        if (paramMap.containsKey("id")) {
            String patId = paramMap.get("id")[0];
            AppointmentDto appDto = ordinacijaFacade.getAppointmentDto();
            PatientDto patientDto = ordinacijaFacade.getPatientDto(patId);
            appDto.setPatient(patientDto);

            model.addAttribute("appointment", appDto);
            
            model.addAttribute("appointments", ordinacijaFacade.getAllAppointmentDtosAfter(patientDto, LocalDate.now().minusDays(1L)));

            model.addAttribute("doctors", ordinacijaFacade.getAllActiveDoctors());
        }

        return "/nurse/add_appointment";

    }

    @RequestMapping(value = "/nurse/add_appointment", params = {"prepare"}, method = RequestMethod.POST)
    public String getAllAppointments(@ModelAttribute AppointmentDto appointmentDto, RedirectAttributes ra) {

        List<Slot> allSlots = generateSlots(appointmentDto.getDate());

        for (AppointmentDto a : ordinacijaFacade.getAllAppointmentDtos(appointmentDto.getDate(), appointmentDto.getDoctor())) {

            Slot s = new Slot();
            s.setDate(a.getDate());
            s.setTime(a.getTime());
            s.setPartNumber(a.getPart());

            if (allSlots.contains(s)) {
                allSlots.get(allSlots.indexOf(s)).setOccupied(true);
            }

        }

        //appointmentDto.setPatient(ordinacijaFacade.getPatientDto(appointmentDto.getPatient().getId()));
        ra.addFlashAttribute("slots", allSlots);
        ra.addFlashAttribute("slot_value", 60 / SLOTS_IN_HOUR);
        ra.addFlashAttribute("appointment", appointmentDto);
        ra.addFlashAttribute("hide", true);

        return "redirect:/nurse/add_appointment";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nurse/add_appointment")
    public String saveAppointment(@ModelAttribute AppointmentDto appointmentDto, RedirectAttributes ra,
            @RequestParam(name = "d") String date, @RequestParam(name = "t") String time, @RequestParam(name = "p") int part) {
        if (ordinacijaFacade.isAppointedAlreadyForDate(appointmentDto.getPatient(), LocalDate.parse(date))) {
            ra.addFlashAttribute("already_appointed", true);
        } else {
            appointmentDto.setDate(LocalDate.parse(date));
            appointmentDto.setTime(LocalTime.parse(time));
            appointmentDto.setPart(part);
            ordinacijaFacade.addAppointment(appointmentDto);
            ordinacijaFacade.sendAppointmentConfirmationMail(appointmentDto);
            ra.addFlashAttribute("appointment_added", true);
        }

        return "redirect:/nurse";
    }
     @RequestMapping(method = RequestMethod.POST, value = "/nurse/delete_appointment/{patient_id}")
    public String deleteAppointment(@ModelAttribute AppointmentDto appointmentDto, @PathVariable (name = "patient_id") String patientId, @RequestParam (name = "app_id") Long app_id) {
        ordinacijaFacade.deleteAppointment(app_id);
        return "redirect:/nurse/add_appointment?id=" + patientId;
    }

    @RequestMapping(value = "/nurse/add_vitals", params = {"id"})
    public String addVitals(@RequestParam(name = "id") String patientId, Model model) {

        model.addAttribute("vitals", ordinacijaFacade.getVitalsDto(patientId));
        return "/nurse/add_vitals";
    }

    @RequestMapping(value = "/nurse/add_vitals", method = RequestMethod.POST)
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
