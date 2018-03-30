/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.service;

import java.util.HashMap;

/**
 *
 * @author asdf
 */
public interface MessagingService {

    void receiveMessage(HashMap<String, String> messageMap);

    void sendPrescriptionUp(HashMap<String, String> messageMap);
}
