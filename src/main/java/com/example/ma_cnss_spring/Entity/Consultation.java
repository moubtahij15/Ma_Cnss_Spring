package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Consultation {
    private int id;
    private String type;
    private int prixRemboursement;
    private Collection<DocumentPris> documentPrisesById;
    private Collection<Dossiermedical> dossiermedicalsById;
    private Collection<MedicamentPris> medicamentPrisesById;

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
    @Column(name = "type", nullable = false, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "prixRemboursement", nullable = false)
    public int getPrixRemboursement() {
        return prixRemboursement;
    }

    public void setPrixRemboursement(int prixRemboursement) {
        this.prixRemboursement = prixRemboursement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consultation that = (Consultation) o;

        if (id != that.id) return false;
        if (prixRemboursement != that.prixRemboursement) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + prixRemboursement;
        return result;
    }

    @OneToMany(mappedBy = "consultationByIdConsultation")
    public Collection<DocumentPris> getDocumentPrisesById() {
        return documentPrisesById;
    }

    public void setDocumentPrisesById(Collection<DocumentPris> documentPrisesById) {
        this.documentPrisesById = documentPrisesById;
    }

    @OneToMany(mappedBy = "consultationByIdConsultation")
    public Collection<Dossiermedical> getDossiermedicalsById() {
        return dossiermedicalsById;
    }

    public void setDossiermedicalsById(Collection<Dossiermedical> dossiermedicalsById) {
        this.dossiermedicalsById = dossiermedicalsById;
    }

    @OneToMany(mappedBy = "consultationByIdConsultation")
    public Collection<MedicamentPris> getMedicamentPrisesById() {
        return medicamentPrisesById;
    }

    public void setMedicamentPrisesById(Collection<MedicamentPris> medicamentPrisesById) {
        this.medicamentPrisesById = medicamentPrisesById;
    }
}
