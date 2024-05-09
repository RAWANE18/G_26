package com.melimed.cabinet.dtos;

import java.util.Date;

public class ConsultationDTO {
    private Long idConsultation;
    private Date dateConsultation;
    private Long ordonnanceId;
    private Long certificatId;

    // Constructors
    public ConsultationDTO() {
    }

    public ConsultationDTO(Long idConsultation, Date dateConsultation, Long ordonnanceId, Long certificatId) {
        this.idConsultation = idConsultation;
        this.dateConsultation = dateConsultation;
        this.ordonnanceId = ordonnanceId;
        this.certificatId = certificatId;
    }

    // Getters and Setters
    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Long getOrdonnanceId() {
        return ordonnanceId;
    }

    public void setOrdonnanceId(Long ordonnanceId) {
        this.ordonnanceId = ordonnanceId;
    }

    public Long getCertificatId() {
        return certificatId;
    }

    public void setCertificatId(Long certificatId) {
        this.certificatId = certificatId;
    }
}
