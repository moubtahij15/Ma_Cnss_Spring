package com.example.ma_cnss_spring.Services;

import com.example.ma_cnss_spring.Dao.AgentRepository;
import com.example.ma_cnss_spring.Entity.Agent;
import com.example.ma_cnss_spring.Security.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Auth {
    private final AgentRepository agentRepository;

    @Autowired
    public Auth(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }


    public boolean authAgent(Agent agent) throws Exception {
        try {
            Agent agent1 = agentRepository.findAgentByEmail(agent.getEmail());
            System.out.println("from try authSErvice");
            return ((agent1 != null) && (Hash.MD5(agent.getPassword()).equals(agent1.getPassword())));
        } catch (Exception e) {
            System.out.println("from catch authSErvice");

            return false;
        }

    }
}
