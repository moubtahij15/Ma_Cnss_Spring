package com.example.ma_cnss_spring.Services;


import com.example.ma_cnss_spring.Dao.DocumentRepository;
import com.example.ma_cnss_spring.Dao.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public int getIdDocumentByCode(String code) {
        return documentRepository.findByCode(code).getId();
    }

}
