package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "document_pris", schema = "macnss", catalog = "")
public class DocumentPris {
    private int id;
    private String code;
    private int idConsultation;
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
    @Column(name = "code", nullable = false, length = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "id_consultation", nullable = false)
    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentPris that = (DocumentPris) o;

        if (id != that.id) return false;
        if (idConsultation != that.idConsultation) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + idConsultation;
        return result;
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
