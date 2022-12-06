package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Medicament {
    private int id;
    private String nom;
    private String codeBarre;
    private Double prixBase;
    private double prixRembourssable;
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
    @Column(name = "nom", nullable = true, length = 100)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "codeBarre", nullable = true, length = 100)
    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    @Basic
    @Column(name = "prixBase", nullable = true, precision = 0)
    public Double getPrixBase() {
        return prixBase;
    }

    public void setPrixBase(Double prixBase) {
        this.prixBase = prixBase;
    }

    @Basic
    @Column(name = "prixRembourssable", nullable = false, precision = 0)
    public double getPrixRembourssable() {
        return prixRembourssable;
    }

    public void setPrixRembourssable(double prixRembourssable) {
        this.prixRembourssable = prixRembourssable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicament that = (Medicament) o;

        if (id != that.id) return false;
        if (Double.compare(that.prixRembourssable, prixRembourssable) != 0) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (codeBarre != null ? !codeBarre.equals(that.codeBarre) : that.codeBarre != null) return false;
        if (prixBase != null ? !prixBase.equals(that.prixBase) : that.prixBase != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (codeBarre != null ? codeBarre.hashCode() : 0);
        result = 31 * result + (prixBase != null ? prixBase.hashCode() : 0);
        temp = Double.doubleToLongBits(prixRembourssable);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "medicamentByIdMedicament")
    public Collection<MedicamentPris> getMedicamentPrisesById() {
        return medicamentPrisesById;
    }

    public void setMedicamentPrisesById(Collection<MedicamentPris> medicamentPrisesById) {
        this.medicamentPrisesById = medicamentPrisesById;
    }
}
