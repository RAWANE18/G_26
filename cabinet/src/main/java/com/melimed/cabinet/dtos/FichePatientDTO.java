package com.melimed.cabinet.dtos;


import java.util.List;

import com.melimed.cabinet.models.Antecedant;
import com.melimed.cabinet.models.Patient;

public class FichePatientDTO {
    private Long idFichePatient;
    private Patient patient;
    private Antecedant antecedant;

    // Constructors
    public FichePatientDTO() {
    }

    public FichePatientDTO(Long idFichePatient, Patient patient) {
        this.idFichePatient = idFichePatient;
        this.patient = patient;
       
    }

    // Getters and Setters
    public Long getIdFichePatient() {
        return idFichePatient;
    }
public Antecedant getAntecedant() {
    return antecedant;
}

    public void setIdFichePatient(Long idFichePatient) {
        this.idFichePatient = idFichePatient;
    }

   public Patient getPatient() {
       return patient;
   }
public void setAntecedant(Antecedant antecedant) {
    this.antecedant = antecedant;
}
public void setPatient(Patient patient) {
    this.patient = patient;
}
    

    
}
