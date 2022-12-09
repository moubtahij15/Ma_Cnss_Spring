package com.example.ma_cnss_spring.controllers;


import com.example.ma_cnss_spring.Entity.Agent;
import com.example.ma_cnss_spring.Entity.Patient;
import com.example.ma_cnss_spring.Services.Auth;
import com.example.ma_cnss_spring.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/patient")
@SessionAttributes("step")
public class PatientController {
    final PatientService patientService;
    final Auth auth;

    @Autowired
    public PatientController(PatientService patientService, Auth auth) {
        this.patientService = patientService;
        this.auth = auth;
    }

    @GetMapping()
    public String index() {
        return "redirect:/agent/login";
    }

    @GetMapping("/login")
    public String loginDisplay(Map<String, Object> model, @ModelAttribute("error") String error) {
//        Agent agent =;
        model.put("patient", new Patient());
        model.put("error", error);
        System.out.println(model.get("step"));
        return "Patient/login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("patient") Patient patient, Model model, RedirectAttributes rattrs) throws Exception {
        System.out.println("from conntrollet logintest");
        if (auth.authPatient(patient)) {
            System.out.println("from conntrollet logintest true");

            return "redirect:/dossier/patient/"+patient.getMatricule();
        }
        System.out.println("from conntrollet logintest false");
        rattrs.addFlashAttribute("error", true);
        model.addAttribute("error", true);
        return "redirect:/patient/login";
    }


}
