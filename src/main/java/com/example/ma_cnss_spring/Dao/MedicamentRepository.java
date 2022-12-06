package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.Consultation;
import com.example.ma_cnss_spring.Entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository("agentRepository")
public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {

    @Query("select medicament from Medicament  medicament where medicament.codeBarre=?1")
    public Medicament findIdByCodeBarre(String codeBarre);
}

