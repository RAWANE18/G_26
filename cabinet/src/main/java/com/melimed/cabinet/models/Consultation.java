package com.melimed.cabinet.models;


import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name="consultations")
public class Consultation {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long idconsultation;

      private Date dateconsultation;

      //foreign keys 
      @ManyToOne(cascade =CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private Patient patient;
      

      //constructeurs
      public Consultation(){}
     
      public Consultation(Long id ,Date dateconsult){
        this.idconsultation=id;
        this.dateconsultation=dateconsult;
  
    }
      
     
    //getters
      public Date getDateconsultation() {
          return dateconsultation;
      }
      public Long getIdconsultation() {
          return idconsultation;
      }
      
      public Patient getPatient() {
          return patient;
      }
     //setters
   public void setPatient(Patient patient) {
       this.patient = patient;
   }
    
      public void setDateconsultation(Date dateconsultation) {
          this.dateconsultation = dateconsultation;
      }
      public void setIdconsultation(Long idconsultation) {
          this.idconsultation = idconsultation;
      }


}
