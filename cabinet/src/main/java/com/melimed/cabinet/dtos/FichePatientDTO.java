package com.melimed.cabinet.dtos;


import java.util.Date;
import com.melimed.cabinet.models.Antecedant;
import com.melimed.cabinet.models.Patient;

public class FichePatientDTO {
    private Long idFichePatient;
    private Antecedant antecedant;
    private Patient patient;
    private String groupesanguin;
    private Date dateCreation;
    private String etatCivil;
    private Long securiteSociale;
    private String profession;
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
    public Date getDateCreation() {
        return dateCreation;
    }
    public String getGroupesanguin() {
        return groupesanguin;
    }
    public String getEtatCivil() {
        return etatCivil;
    }
    public String getProfession() {
        return profession;
    }
    public Long getSecuriteSociale() {
        return securiteSociale;
    }

    
    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public void setSecuriteSociale(Long securiteSociale) {
        this.securiteSociale = securiteSociale;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public void setGroupesanguin(String groupesanguin) {
        this.groupesanguin = groupesanguin;
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
