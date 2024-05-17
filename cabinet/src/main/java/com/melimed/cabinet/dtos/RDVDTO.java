package com.melimed.cabinet.dtos;

import java.util.Calendar;

public class RDVDTO {
    private Long idRdv;
    private Calendar date;
    private Calendar datePriseRdv;
    private String description;
    private Long patientId;

    public RDVDTO() {
    }

    public RDVDTO(Long idRdv, Calendar date, Calendar datePriseRdv, String description, Long patientId) {
        this.idRdv = idRdv;
        this.date = date;
        this.datePriseRdv = datePriseRdv;
        this.description = description;
        this.patientId = patientId;
    }

    public Long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Calendar getDatePriseRdv() {
        return datePriseRdv;
    }

    public void setDatePriseRdv(Calendar datePriseRdv) {
        this.datePriseRdv = datePriseRdv;
    }

    public String getDescription() {
        return description;
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
