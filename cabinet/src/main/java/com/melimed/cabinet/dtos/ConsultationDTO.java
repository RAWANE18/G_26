package com.melimed.cabinet.dtos;

import java.util.Date;

public class ConsultationDTO {
    private Long idConsultation;
    private Date dateConsultation;
    private Long idPatient;

    // Constructors
    public ConsultationDTO() {
    }

    public ConsultationDTO(Long idConsultation, Date dateConsultation, Long idPatient) {
        this.idConsultation = idConsultation;
        this.dateConsultation = dateConsultation;
        this.idPatient = idPatient;
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

    public Long getIdPatient() {
        return idPatient;
    }
    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }
}
