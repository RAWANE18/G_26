package com.melimed.cabinet.models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;

    private Date dateConsultation;

    // foreign keys
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient", referencedColumnName = "idPatient")
    private Patient patient;

    // constructeurs
    public Consultation() {
    }

    public Consultation(Long id, Date dateconsult) {
        this.idConsultation = id;
        this.dateConsultation = dateconsult;

    }

   
    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

}
