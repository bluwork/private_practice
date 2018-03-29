/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.jms;

import java.util.HashMap;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author bobanlukic
 */
@Component
public class PrescriptionReceiver {

    public static final String APP_QUEUE_IDENTIFIER = "ordi123";

    @JmsListener(destination = APP_QUEUE_IDENTIFIER, containerFactory = "myFactory")
    public void receiveMessage(HashMap<String, String> messageMap) {
        System.out.print("Received " + messageMap.get("description"));
    }
}
