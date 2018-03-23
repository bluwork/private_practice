/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import net.ltslab.nst.ordinacija.dto.PatientDto;
import net.ltslab.nst.ordinacija.service.MailSenderService;
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

    @Async
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

        jms.send(smm);

    }

}
