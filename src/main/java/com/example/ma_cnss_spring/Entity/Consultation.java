package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Consultation {
    private int id;
    private String type;
    private Double prixRembourssable;
    private Collection<ConsultationPris> consultationPrisesById;

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
    @Column(name = "type", nullable = true, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "prix_rembourssable", nullable = true, precision = 0)
    public Double getPrixRembourssable() {
        return prixRembourssable;
    }

    public void setPrixRembourssable(Double prixRembourssable) {
        this.prixRembourssable = prixRembourssable;
    }

    public Consultation(String type, Double prixRembourssable) {
        this.type = type;
        this.prixRembourssable = prixRembourssable;
    }

    public Consultation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consultation that = (Consultation) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (prixRembourssable != null ? !prixRembourssable.equals(that.prixRembourssable) : that.prixRembourssable != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (prixRembourssable != null ? prixRembourssable.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "consultationByIdConsultation",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Collection<ConsultationPris> getConsultationPrisesById() {
        return consultationPrisesById;
    }

    public void setConsultationPrisesById(Collection<ConsultationPris> consultationPrisesById) {
        this.consultationPrisesById = consultationPrisesById;
    }
}
