package com.melimed.cabinet.models;


import jakarta.persistence.*;

@Entity
@Table(name = "secretaire")
public class Secretaire {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Idsecretaire;
   
    private String nom;
  
    private String prenom;
   
    private String numtel;


    public long getIdsecretaire() {
        return Idsecretaire;
    }
    public String getNom() {
        return nom;
    }
    public String getNumtel() {
        return numtel;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setIdsecretaire(long idsecretaire) {
        Idsecretaire = idsecretaire;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    

}
