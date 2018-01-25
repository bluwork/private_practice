/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bobanlukic
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String root() {
        return "/home";
    }
    @RequestMapping("/home")
    public String home() {
        return "/home";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "/admin";
    }
    @RequestMapping("/user")
    public String user() {
        return "/user";
    }
    @RequestMapping("/about")
    public String about() {
        return "/about";
    }
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
    @RequestMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
