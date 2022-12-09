package com.example.ma_cnss_spring.Dao;

import com.example.ma_cnss_spring.Entity.Dossiermedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

//@Repository("agentRepository")
public interface DossierMedicalRepository extends JpaRepository<Dossiermedical, Integer> {


    @Transactional
    @Modifying
    @Query("update Dossiermedical dossier set dossier.etat=?1 where dossier.id=?2")
    public int traiterDossier(String etat, int id);

    @Transactional
    @Modifying
    @Query("update Dossiermedical dossier set dossier.mentantBase=?1 ,dossier.mentantRemboussable=?2 where dossier.id=?3")
    public int setMentant(double mentantBase, double mentantRemboursable, int id);

    Dossiermedical findById(int id);
}

