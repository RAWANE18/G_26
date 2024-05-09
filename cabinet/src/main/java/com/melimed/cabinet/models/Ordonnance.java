package com.melimed.cabinet.models;


import jakarta.persistence.*;
@Entity
@Table(name="ordonnances")
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdonnance;

    private String contenu;

    //Foreign key
    
    @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private Patient patient;
    
    //Constructeurs
    public Ordonnance(){}
    public Ordonnance(Long id, String contenu, Patient patient){
        this.idOrdonnance=id;
        this.contenu=contenu;
        this.patient=patient;
    }
    //setters and getters 
    public Patient getPatient() {
        return patient;
    }
    public String getContenu() {
        return contenu;
    }
    public Long getIdOrdonnance() {
        return idOrdonnance;
    }


    public void setPatient(Patient patient) {
      this.patient = patient;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public void setIdOrdonnance(Long idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }
}
