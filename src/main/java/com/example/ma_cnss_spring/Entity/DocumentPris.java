package com.example.ma_cnss_spring.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "document_pris", schema = "macnss", catalog = "")
public class DocumentPris {
    private int id;
    private int idConsultation;
    private Integer idDocument;

    private Double prix;
    private ConsultationPris consultationPrisByIdConsultation;
    private Document documentByIdDocument;

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
    @Column(name = "prix", nullable = false)
    public double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "id_document", nullable = true)
    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentPris that = (DocumentPris) o;

        if (id != that.id) return false;
        if (idConsultation != that.idConsultation) return false;
        if (idDocument != null ? !idDocument.equals(that.idDocument) : that.idDocument != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idConsultation;
        result = 31 * result + (idDocument != null ? idDocument.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_consultation", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ConsultationPris getConsultationPrisByIdConsultation() {
        return consultationPrisByIdConsultation;
    }

    public void setConsultationPrisByIdConsultation(ConsultationPris consultationPrisByIdConsultation) {
        this.consultationPrisByIdConsultation = consultationPrisByIdConsultation;
    }

    @ManyToOne
    @JoinColumn(name = "id_document", referencedColumnName = "id", insertable = false, updatable = false)
    public Document getDocumentByIdDocument() {
        return documentByIdDocument;
    }

    public void setDocumentByIdDocument(Document documentByIdDocument) {
        this.documentByIdDocument = documentByIdDocument;
    }

    public DocumentPris() {
    }

    public DocumentPris(int idConsultation, Integer idDocument) {
        this.idConsultation = idConsultation;
        this.idDocument = idDocument;
    }

    public DocumentPris(int idConsultation, Integer idDocument, Double prix) {
        this.idConsultation = idConsultation;
        this.idDocument = idDocument;
        this.prix = prix;
    }
}
