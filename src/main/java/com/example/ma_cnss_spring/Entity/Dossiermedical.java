package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

@Entity
public class Dossiermedical {
    private int id;
    private double mentantRemboussable;
    private int idConsultation;
    private int idPatient;
    private String etat;
    private Patient patientByIdConsultation;
    private Consultation consultationByIdConsultation;

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
    @Column(name = "mentantRemboussable", nullable = false, precision = 0)
    public double getMentantRemboussable() {
        return mentantRemboussable;
    }

    public void setMentantRemboussable(double mentantRemboussable) {
        this.mentantRemboussable = mentantRemboussable;
    }

    @Basic
    @Column(name = "id_consultation", nullable = false)
    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    @Basic
    @Column(name = "id_patient", nullable = false)
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    @Basic
    @Column(name = "etat", nullable = false)
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dossiermedical that = (Dossiermedical) o;

        if (id != that.id) return false;
        if (Double.compare(that.mentantRemboussable, mentantRemboussable) != 0) return false;
        if (idConsultation != that.idConsultation) return false;
        if (idPatient != that.idPatient) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(mentantRemboussable);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idConsultation;
        result = 31 * result + idPatient;
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_consultation", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public Patient getPatientByIdConsultation() {
        return patientByIdConsultation;
    }

    public void setPatientByIdConsultation(Patient patientByIdConsultation) {
        this.patientByIdConsultation = patientByIdConsultation;
    }

    @ManyToOne
    @JoinColumn(name = "id_consultation", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public Consultation getConsultationByIdConsultation() {
        return consultationByIdConsultation;
    }

    public void setConsultationByIdConsultation(Consultation consultationByIdConsultation) {
        this.consultationByIdConsultation = consultationByIdConsultation;
    }
}
