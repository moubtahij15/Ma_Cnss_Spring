package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicament_pris", schema = "macnss", catalog = "")
public class MedicamentPris {
    private int id;
    private int idConsultation;
    private Integer idMedicament;
    private ConsultationPris consultationPrisByIdConsultation;
    private Medicament medicamentByIdMedicament;

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
    @Column(name = "id_consultation", nullable = false)
    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    @Basic
    @Column(name = "id_medicament", nullable = true)
    public Integer getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(Integer idMedicament) {
        this.idMedicament = idMedicament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicamentPris that = (MedicamentPris) o;

        if (id != that.id) return false;
        if (idConsultation != that.idConsultation) return false;
        if (idMedicament != null ? !idMedicament.equals(that.idMedicament) : that.idMedicament != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idConsultation;
        result = 31 * result + (idMedicament != null ? idMedicament.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "id_medicament", referencedColumnName = "id",insertable = false,updatable = false)
    public Medicament getMedicamentByIdMedicament() {
        return medicamentByIdMedicament;
    }

    public void setMedicamentByIdMedicament(Medicament medicamentByIdMedicament) {
        this.medicamentByIdMedicament = medicamentByIdMedicament;
    }


    public MedicamentPris(int idConsultation, Integer idMedicament) {
        this.idConsultation = idConsultation;
        this.idMedicament = idMedicament;
    }

    public MedicamentPris() {
    }
}
