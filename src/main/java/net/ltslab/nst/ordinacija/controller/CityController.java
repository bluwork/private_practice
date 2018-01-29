/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bobanlukic
 */
@Controller
public class CityController {
    
    @RequestMapping("/all_cities")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "all_cities";
    }
    
}
