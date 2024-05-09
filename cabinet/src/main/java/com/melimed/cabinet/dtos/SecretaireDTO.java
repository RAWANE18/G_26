package com.melimed.cabinet.dtos;

public class SecretaireDTO {
    private long idSecretaire;
    private String nom;
    private String prenom;
    private String numtel;

    // Constructors
    public SecretaireDTO() {
    }

    public SecretaireDTO(long idSecretaire, String nom, String prenom, String numtel) {
        this.idSecretaire = idSecretaire;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
    }

    // Getters and Setters
    public long getIdSecretaire() {
        return idSecretaire;
    }

    public void setIdSecretaire(long idSecretaire) {
        this.idSecretaire = idSecretaire;
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

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }
}
