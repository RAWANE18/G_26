package com.melimed.cabinet.dtos;

import java.util.Date;

public class RDVDTO {
    private Long idRdv;
    private Date date;
    private String description;
    private Long patientId;
    private Date datePriseRdv;

    // Constructors
    public RDVDTO() {
    }

    public RDVDTO(Long idRdv, Date date, String description, Long patientId) {
        this.idRdv = idRdv;
        this.date = date;
        this.description = description;
        this.patientId = patientId;
    }

    // Getters and Setters
    public Long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }

    public Date getDate() {
        return date;
    }
 
    public Date getDatePriseRdv() {
        return datePriseRdv;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDatePriseRdv(Date datePriseRdv) {
        this.datePriseRdv = datePriseRdv;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
