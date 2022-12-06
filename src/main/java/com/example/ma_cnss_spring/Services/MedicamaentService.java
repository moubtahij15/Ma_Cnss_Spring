package com.example.ma_cnss_spring.Services;


import com.example.ma_cnss_spring.Dao.MedicamentRepository;
import com.example.ma_cnss_spring.Dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamaentService {

    MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamaentService(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    public int getIdPatientByCode(String code) {
        return medicamentRepository.findIdByCodeBarre(code).getId();
    }

}
