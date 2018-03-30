/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Appointment;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;

/**
 *
 * @author bobanlukic
 */
public interface AppointmentService {

    AppointmentDto getAppointmentDto();

    List<AppointmentDto> getAllAppointmentDtos(LocalDate date, AppUserDto doctor);

    List<Appointment> findByDoctorAndDate(AppUser currentDoctor, LocalDate now);

    List<Appointment> findByDate(LocalDate now);

    void addAppointment(AppointmentDto appointmentDto);

    boolean isAppointedAlreadyForDate(PatientDto patient, LocalDate date);

    void confirmAppointmentRealization(PatientDto patient, LocalDate date);

    List<Appointment> findByDateAndRealizedTrue(LocalDate now);

    List<Appointment> findByDateAndRealizedFalse(LocalDate now);

    List<Appointment> findByDoctorAndDateAndRealizedFalse(AppUser currentDoctor, LocalDate now);

    List<AppointmentDto> getAllAppointmentDtosAfter(PatientDto patientDto, LocalDate date);

    void deleteAppointment(Long appointmentId);

    public AppointmentDto getAppointmentDto(Long id);

}
