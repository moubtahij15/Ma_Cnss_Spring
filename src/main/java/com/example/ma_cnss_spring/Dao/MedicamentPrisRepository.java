package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.Medicament;
import com.example.ma_cnss_spring.Entity.MedicamentPris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository("agentRepository")
public interface MedicamentPrisRepository extends JpaRepository<MedicamentPris, Integer> {

    MedicamentPris findById(int id);
}

