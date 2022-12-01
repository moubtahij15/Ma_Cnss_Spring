package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

@Entity
public class Document {
    private int id;
    private String nom;
    private String type;
    private String code;
    private Integer tauxRemboursement;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (id != document.id) return false;
        if (nom != null ? !nom.equals(document.nom) : document.nom != null) return false;
        if (type != null ? !type.equals(document.type) : document.type != null) return false;
        if (code != null ? !code.equals(document.code) : document.code != null) return false;
        if (tauxRemboursement != null ? !tauxRemboursement.equals(document.tauxRemboursement) : document.tauxRemboursement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (tauxRemboursement != null ? tauxRemboursement.hashCode() : 0);
        return result;
    }
}
