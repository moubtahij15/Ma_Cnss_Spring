package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Document {
    private int id;
    private String nom;
    private String type;
    private String code;
    private Integer tauxRemboursement;
    private Collection<DocumentPris> documentPrisesById;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 100)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 200)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "tauxRemboursement", nullable = true)
    public Integer getTauxRemboursement() {
        return tauxRemboursement;
    }

    public void setTauxRemboursement(Integer tauxRemboursement) {
        this.tauxRemboursement = tauxRemboursement;
    }


    @OneToMany(mappedBy = "documentByIdDocument")
    public Collection<DocumentPris> getDocumentPrisesById() {
        return documentPrisesById;
    }

    public void setDocumentPrisesById(Collection<DocumentPris> documentPrisesById) {
        this.documentPrisesById = documentPrisesById;
    }

}
