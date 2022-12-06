package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.DocumentPris;
import com.example.ma_cnss_spring.Entity.MedicamentPris;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository("agentRepository")
public interface DocumentPrisRepository extends JpaRepository<DocumentPris, Integer> {
    DocumentPris findById(int id);

}

