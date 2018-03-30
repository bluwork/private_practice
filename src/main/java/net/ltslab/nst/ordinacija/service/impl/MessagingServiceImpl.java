/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service.impl;

import java.util.HashMap;
import net.ltslab.nst.ordinacija.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author asdf
 */
@Service
public class MessagingServiceImpl implements MessagingService{

    
     public static final String APP_QUEUE_IDENTIFIER = "fromGlobal";
     public static final String GLOBAL_QUEUE_IDENTIFIER = "toGlobal";
     
     @Autowired
     JmsTemplate jmsTemplate;

    @JmsListener(destination = APP_QUEUE_IDENTIFIER, containerFactory = "myFactory")
    @Override
    public void receiveMessage(HashMap<String, String> messageMap) {
        System.out.print("Received " + messageMap.get("description"));
    }

    @Override
    public void sendPrescriptionUp(HashMap<String, String> messageMap) {
        System.out.println("Sending an prescription message.");
        jmsTemplate.convertAndSend(GLOBAL_QUEUE_IDENTIFIER, messageMap);
    }
    
}
