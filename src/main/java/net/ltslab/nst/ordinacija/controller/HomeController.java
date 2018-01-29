/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bobanlukic
 */
@Controller
public class HomeController {
    

    @RequestMapping("/")
    public String root() {
        return "login";
    }
    
     @RequestMapping("/home")
    public String home() {
        return "redirect:login";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/403")
    public String accessDenied() {
        return "error/403";
    }
}
