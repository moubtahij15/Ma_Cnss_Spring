package com.example.ma_cnss_spring.Services;


import com.example.ma_cnss_spring.Dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public int getIdPatientByMatricule(String matricule) {
        return patientRepository.findIdByMatricule(matricule).getId();
    }

}
