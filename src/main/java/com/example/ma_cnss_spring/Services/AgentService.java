package com.example.ma_cnss_spring.Services;


import com.example.ma_cnss_spring.Dao.AgentRepository;
import com.example.ma_cnss_spring.Entity.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent save(Agent agent) {
        agentRepository.save(agent);
        return agent;
    }

}
