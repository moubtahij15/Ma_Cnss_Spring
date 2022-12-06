package com.example.ma_cnss_spring.Entity;

import com.example.ma_cnss_spring.Helpers.Etat;
import jakarta.persistence.*;

@Entity
public class Dossiermedical {
    private int id;
    private double mentantRemboussable;
    private int idConsultation;
    private int idPatient;
    private String etat;
    private Double mentantBase;
    private ConsultationPris consultationPrisByIdConsultation;
    private Patient patientByIdPatient;

    public Dossiermedical() {
    }

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

    @Basic
    @Column(name = "mentant_base", nullable = true, precision = 0)
    public Double getMentantBase() {
        return mentantBase;
    }

    public void setMentantBase(Double mentantBase) {
        this.mentantBase = mentantBase;
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
        if (mentantBase != null ? !mentantBase.equals(that.mentantBase) : that.mentantBase != null) return false;

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
        result = 31 * result + (mentantBase != null ? mentantBase.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_consultation", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public ConsultationPris getConsultationPrisByIdConsultation() {
        return consultationPrisByIdConsultation;
    }

    public void setConsultationPrisByIdConsultation(ConsultationPris consultationPrisByIdConsultation) {
        this.consultationPrisByIdConsultation = consultationPrisByIdConsultation;
    }

    public Dossiermedical(int idConsultation, int idPatient) {
        this.idConsultation = idConsultation;
        this.idPatient = idPatient;
        this.etat= Etat.EN_ATTENTE.toString();
    }

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public Patient getPatientByIdPatient() {
        return patientByIdPatient;
    }

    public void setPatientByIdPatient(Patient patientByIdPatient) {
        this.patientByIdPatient = patientByIdPatient;
    }
}
