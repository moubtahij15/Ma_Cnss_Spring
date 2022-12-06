package com.example.ma_cnss_spring.Services;

import com.example.ma_cnss_spring.Dao.ConsultationRepository;
import com.example.ma_cnss_spring.Entity.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

}
