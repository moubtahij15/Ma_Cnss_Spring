package com.example.ma_cnss_spring.controllers;


import com.example.ma_cnss_spring.Dao.ConsultationPrisRepository;
import com.example.ma_cnss_spring.Entity.*;
import com.example.ma_cnss_spring.Helpers.Etat;
import com.example.ma_cnss_spring.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("dossier")
@SessionAttributes({"step", "id_consultation", "id_dossier", "currentDossier"})
@Controller
public class DossierMedicalController {
    final DossierMedicalService dossierMedicalService;
    final ConsultationService consultationService;
    final PatientService patientService;
    final ConsultationPrisService consultationPrisService;
    final MedicamaentService medicamaentService;
    final MedicamaentPrisService medicamaentPrisService;
    final DocumentService documentService;
    final DocumentPrisService documentPrisService;

    @Autowired
    public DossierMedicalController(DossierMedicalService dossierMedicalService, ConsultationService consultationService, PatientService patientService, ConsultationPrisService consultationPrisService, MedicamaentService medicamaentService, MedicamaentPrisService medicamaentPrisService, DocumentPrisService documentPrisService, DocumentService documentService) {
        this.dossierMedicalService = dossierMedicalService;
        this.consultationService = consultationService;
        this.patientService = patientService;
        this.consultationPrisService = consultationPrisService;
        this.medicamaentService = medicamaentService;
        this.medicamaentPrisService = medicamaentPrisService;
        this.documentPrisService = documentPrisService;
        this.documentService = documentService;
    }

    @GetMapping()
    public String diplayDossier(Map<String, Object> model) {
        model.put("listDossier", dossierMedicalService.findAll());
        model.put("dossierTraiter", new Dossiermedical());
        return "Agent/dashboard";

    }

    @GetMapping("/add")
    String displayAddDossier(Map<String, Object> model) {
        model.put("consultations", consultationService.findAll());

        model.putIfAbsent("currentDossier", new Dossiermedical());
        model.putIfAbsent("step", 1);

        model.put("dossier", new Object());
        model.put("currentDossier", (Dossiermedical) model.get("currentDossier"));
        return "Agent/addDossier";
    }

    @PostMapping("/add")
    String submitAddDossier(Map<String, Object> model, @RequestParam(value = "code", defaultValue = "0") String code, @RequestParam(value = "type", required = false, defaultValue = "0") int type, @RequestParam(value = "prix", defaultValue = "0") Double prix) {

        Dossiermedical currentDossier = (Dossiermedical) model.get("currentDossier");
        System.out.println(currentDossier.getIdConsultation() + " from main ");
        int step = (int) model.get("step");
        System.out.println(step);
        if (step == 1) {
//            step1 : get matricul for geting id patient and get id_consultation for saving consultation
//                    and c

            ConsultationPris consultationPris = consultationPrisService.save(new ConsultationPris(type));//save consultation and get id for current consultation
//            int idConsultationPris = consultationPrisService.save(new ConsultationPris(type)).getId();//save consultation and get id for current consultation
            int idDossier = dossierMedicalService.save(new Dossiermedical(
                    consultationPris.getId(),
                    patientService.getIdPatientByMatricule(code)
            )).getId();
//            save some id in session
//            currentDossier= (Dossiermedical) model.get("currentDossier");
            currentDossier.setIdConsultation(consultationPris.getId());
            currentDossier.setId(idDossier);
            System.out.println(consultationPris.getConsultationByIdConsultation());
            currentDossier.setMentantRemboussable(consultationPris.getConsultationByIdConsultation().getPrixRembourssable());
             model.put("step", 2);


            model.put("currentDossier", currentDossier);

        } else if (step == 2) {


            MedicamentPris medicamentPris = medicamaentPrisService.save(new MedicamentPris(currentDossier.getIdConsultation(), medicamaentService.getIdPatientByCode(code)));

            currentDossier.setMentantRemboussable(currentDossier.getMentantRemboussable() + medicamentPris.getMedicamentByIdMedicament().getPrixRembourssable());

//
            model.put("currentDossier", currentDossier);

        } else if (step == 3) {

            DocumentPris documentPris = documentPrisService.save(new DocumentPris(currentDossier.getIdConsultation(), documentService.getIdDocumentByCode(code), prix));
            currentDossier.setMentantRemboussable(currentDossier.getMentantRemboussable() + ((prix * documentPris.getDocumentByIdDocument().getTauxRemboursement()) / 100));
            model.put("currentDossier", currentDossier);


        } else if (step == 4) {

        }
        return "redirect:/dossier/add";

    }

    @PostMapping("next")
    String nextStep(Map<String, Object> model) {
        int step = (int) model.get("step");
        if (step == 2) {
            model.put("step", 3);
        } else if (step == 3) {
            model.put("step", 4);
        } else if (step == 4) {
            model.put("step", 1);
        }
        return "redirect:/dossier/add";

    }

    @PostMapping("/traiter/{id}")
    public String traiterDossier(@PathVariable int id, @RequestParam("etat") String etat) {
        if (etat.equals(Etat.ACCEPTED.toString())) {
            dossierMedicalService.validerDocumentMedical(id);
        } else dossierMedicalService.refuserDocumentMedical(id);
        return "redirect:/dossier";

    }
}
