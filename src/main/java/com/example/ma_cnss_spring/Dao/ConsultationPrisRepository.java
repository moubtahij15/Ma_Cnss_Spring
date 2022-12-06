package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.ConsultationPris;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository("agentRepository")
public interface ConsultationPrisRepository extends JpaRepository<ConsultationPris, Integer> {
    ConsultationPris findById(int id);
}

