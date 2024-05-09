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
     
      @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
      @CollectionTable(name = "ficheConsultations", joinColumns = @JoinColumn(name = "idconsultation"))
      @Column(name = "idconsultation", nullable = false, insertable=false, updatable = false)
      private List<Consultation> consultation = new ArrayList<>();
    
      
     //constructeurs
  public FichePatient(){}
  public FichePatient(Long id, Patient patient){
    this.patient=patient;
    this.idFichePatient=id;
  }
 

     //setters and getters
     public List<Consultation> getConsultation() {
         return consultation;
     }
     public Long getIdFichePatient() {
         return idFichePatient;
     }
     public Patient getPatient() {
         return patient;
     }
     
     
     public void setConsultation(List<Consultation> consultation) {
         this.consultation = consultation;
     }
     public void setIdFichePatient(Long idFichePatient) {
         this.idFichePatient = idFichePatient;
     }
     public void setPatient(Patient patient) {
         this.patient = patient;
     }




 }
