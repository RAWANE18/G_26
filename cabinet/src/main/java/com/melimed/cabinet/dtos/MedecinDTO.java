package com.melimed.cabinet.dtos;

public class MedecinDTO {
    private long idMedecin;
    private String specialite;
    private String nom;
    private String prenom;
    private String numTel;

    // Constructors
    public MedecinDTO() {
    }

    public MedecinDTO(long idMedecin, String specialite, String nom, String prenom, String numTel) {
        this.idMedecin = idMedecin;
        this.specialite = specialite;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
    }

    // Getters and Setters
    public long getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }
}
