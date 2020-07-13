/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.util.List;
import net.ltslab.nst.ordinacija.dto.AppUserDto;
import net.ltslab.nst.ordinacija.facade.OrdinacijaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author blu
 */

@RestController
public class AdminRestController {
    
    @Autowired
    OrdinacijaFacade facade;
    
    @RequestMapping("/admin/rest")
    public List<AppUserDto> rest() {
        return facade.getAllUsers();
    }
}
