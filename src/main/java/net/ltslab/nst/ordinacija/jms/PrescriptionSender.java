/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.jms;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author bobanlukic
 */
@Component
public class PrescriptionSender {

    public static final String GLOBAL_QUEUE_IDENTIFIER = "global123";

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendPrescriptionUp(HashMap<String, String> messageMap) {
        System.out.println("Sending an prescription message.");
        jmsTemplate.convertAndSend(GLOBAL_QUEUE_IDENTIFIER, messageMap);
    }

}
