package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.Document;
import com.example.ma_cnss_spring.Entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository("agentRepository")
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    public Document findByCode(String code);
}

