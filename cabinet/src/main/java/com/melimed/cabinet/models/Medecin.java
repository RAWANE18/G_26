package com.melimed.cabinet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "medecin")
public class Medecin {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Idmedecin;
    private String specialite;
    private String nom;
    private String prenom;
    private String numTel; 

    //getters
    public long getIdmedecin() {
        return Idmedecin;
    }
    public String getNom() {
        return nom;
    }
    public String getNumTel() {
        return numTel;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getSpecialite() {
        return specialite;
    }
    

    //setters
    public void setIdmedecin(long idmedecin) {
        Idmedecin = idmedecin;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    

}
