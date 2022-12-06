package com.example.ma_cnss_spring.Services;


import com.example.ma_cnss_spring.Dao.DocumentPrisRepository;
import com.example.ma_cnss_spring.Dao.MedicamentPrisRepository;
import com.example.ma_cnss_spring.Entity.DocumentPris;
import com.example.ma_cnss_spring.Entity.MedicamentPris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentPrisService {

    DocumentPrisRepository documentPrisRepository;

    @Autowired
    public DocumentPrisService(DocumentPrisRepository documentPrisRepository) {
        this.documentPrisRepository = documentPrisRepository;
    }

    public DocumentPris save(DocumentPris documentPris) {

        return documentPrisRepository.findById(documentPrisRepository.save(documentPris).getId());
    }
}
