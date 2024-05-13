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
    @ManyToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="consultation" , referencedColumnName = "idconsultation" )
      private Consultation consultation;
    //Constructeurs
    public Ordonnance(){}
    public Ordonnance(Long id, String contenu, Patient patient, Consultation consultation){
        this.idOrdonnance=id;
        this.contenu=contenu;
        this.patient=patient;
        this.consultation=consultation;
        
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
    public Consultation getConsultation() {
        return consultation;
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
    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
    
}
