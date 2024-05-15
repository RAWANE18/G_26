package com.melimed.cabinet.models;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Entity
@Table(name="fichespatients")
public class FichePatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichePatient;
   
    //Foreign keys

    @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private Patient patient;
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="Antecedant" , referencedColumnName = "idAntecedant" )
      private Antecedant antecedant;
        
    
      
     //constructeurs
  public FichePatient(){}
  public FichePatient(Long id, Patient patient){
    this.patient=patient;
    this.idFichePatient=id;
  }
 

     //setters and getters
     public Antecedant getAntecedant() {
         return antecedant;
     }
     public void setAntecedant(Antecedant antecedant) {
         this.antecedant = antecedant;
     }
     public Long getIdFichePatient() {
         return idFichePatient;
     }
     public Patient getPatient() {
         return patient;
     }
     
     

     public void setIdFichePatient(Long idFichePatient) {
         this.idFichePatient = idFichePatient;
     }
     public void setPatient(Patient patient) {
         this.patient = patient;
     }




 }
