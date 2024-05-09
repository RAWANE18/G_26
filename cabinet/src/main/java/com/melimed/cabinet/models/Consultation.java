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
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="ordonnance" , referencedColumnName = "idOrdonnance" )
      private Ordonnance ordonnance;
     
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="certificat" , referencedColumnName = "IdCertificat" )
      private Certificat certificat;
     

      //constructeurs
      public Consultation(){}
     
      public Consultation(Long id ,Date dateconsult, Ordonnance ordonnance , Certificat certificat){
        this.idconsultation=id;
        this.dateconsultation=dateconsult;
        this.certificat=certificat;
        this.ordonnance=ordonnance;  
    }
      
     
    //getters
      public Date getDateconsultation() {
          return dateconsultation;
      }
      public Long getIdconsultation() {
          return idconsultation;
      }
      public Certificat getCertificat() {
          return certificat;
      }
      public Ordonnance getOrdonnance() {
          return ordonnance;
      }
     //setters

    public void setCertificat(Certificat certificat) {
        this.certificat = certificat;
    }
    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }
      public void setDateconsultation(Date dateconsultation) {
          this.dateconsultation = dateconsultation;
      }
      public void setIdconsultation(Long idconsultation) {
          this.idconsultation = idconsultation;
      }


}
