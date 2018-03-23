/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import net.ltslab.nst.ordinacija.dto.PatientDto;

/**
 *
 * @author bobanlukic
 */
public interface MailSenderService {

    void sendEmail(PatientDto patient, String subject, String messageText);
}
