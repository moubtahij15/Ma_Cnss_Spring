package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.Consultation;
import com.example.ma_cnss_spring.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository("agentRepository")
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("select patient from Patient  patient where patient.matricule=?1")
    public Patient findIdByMatricule(String matricule);
}

