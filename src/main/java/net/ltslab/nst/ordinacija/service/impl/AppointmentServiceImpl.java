/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.time.LocalDate;
import java.util.List;
import net.ltslab.nst.ordinacija.domain.AppUser;
import net.ltslab.nst.ordinacija.domain.Appointment;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
import net.ltslab.nst.ordinacija.mapping.AppUserMapper;
import net.ltslab.nst.ordinacija.mapping.AppointmentMapper;
import net.ltslab.nst.ordinacija.repository.AppointmentRepository;
import net.ltslab.nst.ordinacija.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{

    
    @Autowired
    AppointmentRepository appointmentRepository;
    
    @Autowired
    AppointmentMapper appointmentMapper;
    
    @Autowired
    AppUserMapper appUserMapper;
    
    @Override
    public List<Appointment> findByDoctorAndDate(AppUser currentDoctor, LocalDate date) {
        return appointmentRepository.findByDoctorAndDateOrderByTimeAscPartAsc(currentDoctor, date);
    }

    @Override
    public List<Appointment> findByDate(LocalDate date) {
        return appointmentRepository.findByDateOrderByTimeAscPartAsc(date);
    }

    @Override
    public AppointmentDto getAppointmentDto() {
        return appointmentMapper.appointmentToAppointmentDto(new Appointment());
    }

    @Override
    public List<AppointmentDto> getAllAppointmentDtos(LocalDate date, AppUserDto doctor) {
        return appointmentMapper.appointementsToAppointementDtos(appointmentRepository.findByDoctorAndDateOrderByTimeAscPartAsc(appUserMapper.appUserDtoToAppUser(doctor), date));
    }

    @Override
    public void addAppointment(AppointmentDto appointmentDto) {
        appointmentRepository.saveAndFlush(appointmentMapper.appointmentDtoToAppointment(appointmentDto));
    }
    
}
