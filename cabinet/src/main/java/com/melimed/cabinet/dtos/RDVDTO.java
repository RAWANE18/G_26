package com.melimed.cabinet.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RDVDTO {
    private Long idRdv;
    private LocalDate date;
    private LocalTime time;
    private LocalDate datePriseRdv;
    private String description;
    private Long patientId;

    public RDVDTO() {
    }

    public RDVDTO(Long idRdv, String description, Long patientId) {
        this.idRdv = idRdv;
       
        this.description = description;
        this.patientId = patientId;
    }

    public Long getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }

    public LocalDate getDate() {
        return date;
    }
 public LocalDate getDatePriseRdv() {
     return datePriseRdv;
 }
    public LocalTime getTime() {
        return time;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setDatePriseRdv(LocalDate datePriseRdv) {
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
