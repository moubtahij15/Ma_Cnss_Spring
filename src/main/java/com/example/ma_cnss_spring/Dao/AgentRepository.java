package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository("agentRepository")
public interface AgentRepository extends JpaRepository<Agent, Integer> {

    @Query("select agent from Agent agent where agent.email =?1")
    Agent findAgentByEmail(String email);

    Agent findByEmail(String email);
}
