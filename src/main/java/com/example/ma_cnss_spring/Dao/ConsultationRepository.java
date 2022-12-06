package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository("agentRepository")
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

}

