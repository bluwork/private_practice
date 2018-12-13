/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.dto.AppointmentDto;
import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.service.AppUserService;
import net.ltslab.nst.ordinacija.service.AppointmentService;
import net.ltslab.nst.ordinacija.service.MailSenderService;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author bobanlukic
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {

    @Autowired
    private JavaMailSender jms;

    @Autowired
    private AppointmentService appoinmentService;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PatientService patientService;

    @Override
    public void sendEmail(PatientDto patientDto, String subject, String messageText) throws MailException {

        String patientMail = patientDto.getContactInfo().getEmail();

        if (patientMail == null || patientMail.isEmpty()) {
            return;
        }

        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(patientDto.getContactInfo().getEmail());
        smm.setFrom("ordiaplikacija@gmail.com");
        smm.setSubject(subject);
        smm.setText(messageText);

        send(smm);

    }

    @Override
    public void sendAppointmentConfirmation(AppointmentDto dto) {

        PatientDto patient = patientService.getPatientById(dto.getPatient().getId());

        String patientMail = patient.getContactInfo().getEmail();

        AppUserDto doctor = appUserService.getById(dto.getDoctor().getId());

        if (patientMail == null || patientMail.isEmpty()) {
            return;
        }

        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(patientMail);
        smm.setFrom("ordiaplikacija@gmail.com");
        smm.setSubject("Ordinacija Appointment confirmation");
        smm.setText("Dear  " + patient.getFirstName() + ",\n"
                + "You make appointment for " + dto.getDate() + " in " + dto.getTime() + "\n"
                + "Your doctor: " + doctor.getFirstName() + "  " + doctor.getLastName() + ". \nKing regards.");

        send(smm);
    }

    @Async
    private void send(SimpleMailMessage smm) {
        jms.send(smm);
    }
}
