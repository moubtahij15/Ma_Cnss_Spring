package com.example.ma_cnss_spring.Services;


import com.example.ma_cnss_spring.Dao.MedicamentPrisRepository;
import com.example.ma_cnss_spring.Dao.MedicamentRepository;
import com.example.ma_cnss_spring.Entity.MedicamentPris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamaentPrisService {

    MedicamentPrisRepository medicamentPrisRepository;

    @Autowired
    public MedicamaentPrisService(MedicamentPrisRepository medicamentPrisRepository) {
        this.medicamentPrisRepository = medicamentPrisRepository;
    }

    public MedicamentPris save(MedicamentPris medicamentPris) {
        return medicamentPrisRepository.findById(medicamentPrisRepository.save(medicamentPris).getId());
    }
}
