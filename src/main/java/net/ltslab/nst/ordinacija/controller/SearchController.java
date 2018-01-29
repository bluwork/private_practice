/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.controller;

import java.util.List;
import net.ltslab.nst.ordinacija.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bobanlukic
 */
@Controller
public class SearchController {
    
    @Autowired
    private PatientService patientService;
    
    @RequestMapping("/search")
    public String search(@RequestParam(value="q") String searchText, Model model) {
    List searchResults = null;
    try {
      searchResults = patientService.searchForPatient(searchText);
    }
    catch (Exception ex) {
      // here you should handle unexpected errors
      // ...
      // throw ex;
    }
    model.addAttribute("searchResults", searchResults);
    return "search";
  }
    
    
}
