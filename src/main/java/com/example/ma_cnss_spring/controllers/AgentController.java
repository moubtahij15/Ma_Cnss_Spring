package com.example.ma_cnss_spring.controllers;


import com.example.ma_cnss_spring.Entity.Agent;
import com.example.ma_cnss_spring.Services.AgentService;
import com.example.ma_cnss_spring.Services.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/agent")
//@SessionAttributes({"step", "currentDossier"})
@SessionAttributes("step")
public class AgentController {

    final AgentService agentService;
    final Auth auth;

    @Autowired
    public AgentController(AgentService agentService, Auth auth) {
        this.agentService = agentService;
        this.auth = auth;
    }

    @GetMapping()
    public String index() {
        return "redirect:/agent/login";
    }

    @GetMapping("/login")
    public String loginDisplay(Map<String, Object> model, @ModelAttribute("error") String error) {
//        Agent agent =;
        model.put("agent", new Agent());
        model.put("error", error);
        System.out.println(model.get("step"));
        return "Agent/login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("agent") Agent agent, Model model, RedirectAttributes rattrs) throws Exception {
        System.out.println("from conntrollet logintest");
        if (auth.authAgent(agent)) {
            System.out.println("from conntrollet logintest true");
            return "redirect:/dossier";
        }
        System.out.println("from conntrollet logintest false");
        rattrs.addFlashAttribute("error", true);
        model.addAttribute("error", true);
        return "redirect:/agent/login";
    }


}
