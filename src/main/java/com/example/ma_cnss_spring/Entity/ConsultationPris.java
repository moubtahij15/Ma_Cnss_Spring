package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "consultation_pris", schema = "macnss", catalog = "")
public class ConsultationPris {
    private int id;
    private Integer idConsultation;
    private Consultation consultationByIdConsultation;
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
    @Column(name = "id_consultation", nullable = true)
    public Integer getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Integer idConsultation) {
        this.idConsultation = idConsultation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsultationPris that = (ConsultationPris) o;

        if (id != that.id) return false;
        if (idConsultation != null ? !idConsultation.equals(that.idConsultation) : that.idConsultation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idConsultation != null ? idConsultation.hashCode() : 0);
        return result;
    }

    public ConsultationPris(Integer idConsultation) {
        this.idConsultation = idConsultation;
    }

    public ConsultationPris() {
    }

    @ManyToOne
    @JoinColumn(name = "id_consultation", referencedColumnName = "id", insertable = false, updatable = false)
    public Consultation getConsultationByIdConsultation() {
        return consultationByIdConsultation;
    }

    public void setConsultationByIdConsultation(Consultation consultationByIdConsultation) {
        this.consultationByIdConsultation = consultationByIdConsultation;
    }

    @OneToMany(mappedBy = "consultationPrisByIdConsultation",   fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Collection<DocumentPris> getDocumentPrisesById() {
        return documentPrisesById;
    }

    public void setDocumentPrisesById(Collection<DocumentPris> documentPrisesById) {
        this.documentPrisesById = documentPrisesById;
    }

    @OneToMany(mappedBy = "consultationPrisByIdConsultation", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Collection<Dossiermedical> getDossiermedicalsById() {
        return dossiermedicalsById;
    }

    public void setDossiermedicalsById(Collection<Dossiermedical> dossiermedicalsById) {
        this.dossiermedicalsById = dossiermedicalsById;
    }

    @OneToMany(mappedBy = "consultationPrisByIdConsultation", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Collection<MedicamentPris> getMedicamentPrisesById() {
        return medicamentPrisesById;
    }

    public void setMedicamentPrisesById(Collection<MedicamentPris> medicamentPrisesById) {
        this.medicamentPrisesById = medicamentPrisesById;
    }
}
