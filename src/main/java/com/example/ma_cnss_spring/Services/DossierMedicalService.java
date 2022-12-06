package com.example.ma_cnss_spring.Services;


import com.example.ma_cnss_spring.Dao.DossierMedicalRepository;
import com.example.ma_cnss_spring.Entity.Dossiermedical;
import com.example.ma_cnss_spring.Helpers.Etat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierMedicalService {
    final DossierMedicalRepository dossierMedicalRepository;

    @Autowired
    public DossierMedicalService(DossierMedicalRepository dossierMedicalRepository) {
        this.dossierMedicalRepository = dossierMedicalRepository;
    }


    public List<Dossiermedical> findAll() {
        return dossierMedicalRepository.findAll().stream().filter(dossiermedical -> dossiermedical.getEtat().equals(Etat.EN_ATTENTE.toString())).toList();
    }

    public void validerDocumentMedical(int id) {
        dossierMedicalRepository.traiterDossier(Etat.ACCEPTED.toString(), id);
    }

    public void refuserDocumentMedical(int id) {
        dossierMedicalRepository.traiterDossier(Etat.REFUSER.toString(), id);
    }

    public Dossiermedical save(Dossiermedical dossiermedical) {
        return dossierMedicalRepository.save(dossiermedical);
    }
}
