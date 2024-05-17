package com.melimed.cabinet.models;

import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name="certificats")
public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCertificat;

    @Column(name = "contenu")
    private String contenu;

    private Date dateDelivrance;
    private Date dateExpiration;
    //Foreign key
    
    @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private Patient patient;
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="consultation" , referencedColumnName = "idconsultation" )
      private Consultation idconsultation; 
    
    
   //constructeurs

   public Certificat(){}
   public Certificat(Long id,Patient patient, String contenu, Date datedelivrance, Date dateexp,Consultation idconsultation){
    this.IdCertificat=id;
    this.contenu=contenu;
    this.dateDelivrance=datedelivrance;
    this.dateExpiration=dateexp;
    this.patient=patient;
    this.idconsultation=idconsultation;
   }
    //getters
    public String getContenu() {
        return contenu;
    }
    public Date getDateDelivrance() {
        return dateDelivrance;
    }
    public Date getDateExpiration() {
        return dateExpiration;
    }
    public Long getIdCertificat() {
        return IdCertificat;
    }
    public Patient getPatient() {
        return patient;
    }
    public Consultation getIdconsultation() {
        return idconsultation;
    }
    
    //setters
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }
    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
    public void setIdCertificat(Long idCertificat) {
        IdCertificat = idCertificat;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setIdconsultation(Consultation idconsultation) {
        this.idconsultation = idconsultation;
    }
    
}
