package com.example.ma_cnss_spring.Services;

import com.example.ma_cnss_spring.Dao.ConsultationPrisRepository;
import com.example.ma_cnss_spring.Entity.ConsultationPris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationPrisService {
    final ConsultationPrisRepository consultationPrisRepository;

    @Autowired
    public ConsultationPrisService(ConsultationPrisRepository consultationPrisRepository) {
        this.consultationPrisRepository = consultationPrisRepository;
    }

    public ConsultationPris save(ConsultationPris consultationPris) {
        return consultationPrisRepository.findById(consultationPrisRepository.save(consultationPris).getId());
    }

}
