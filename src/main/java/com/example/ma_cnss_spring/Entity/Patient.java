package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String matricule;
    private Collection<Dossiermedical> dossiermedicalsById;

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
    @Column(name = "nom", nullable = false, length = 200)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 200)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "matricule", nullable = false, length = 200)
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != patient.id) return false;
        if (nom != null ? !nom.equals(patient.nom) : patient.nom != null) return false;
        if (prenom != null ? !prenom.equals(patient.prenom) : patient.prenom != null) return false;
        if (email != null ? !email.equals(patient.email) : patient.email != null) return false;
        if (password != null ? !password.equals(patient.password) : patient.password != null) return false;
        if (matricule != null ? !matricule.equals(patient.matricule) : patient.matricule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (matricule != null ? matricule.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "patientByIdPatient")
    public Collection<Dossiermedical> getDossiermedicalsById() {
        return dossiermedicalsById;
    }

    public void setDossiermedicalsById(Collection<Dossiermedical> dossiermedicalsById) {
        this.dossiermedicalsById = dossiermedicalsById;
    }
}
