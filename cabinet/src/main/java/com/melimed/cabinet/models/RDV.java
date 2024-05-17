package com.melimed.cabinet.models;
import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name="RendezVous")
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;

    private Calendar date;
	private Calendar datePriseRdv;
	private String description;
	
    //Foreign key
    @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private Patient patient;

    //constructeurs
    public RDV(){}
    public RDV(Long id, Calendar date, String description, Patient patient){
       this.idRdv=id;
       this.date=date;
       this.description=description;
       this.patient=patient;
    }  
    //getters
    public Long getIdRdv() {
        return idRdv;
    }
    public Calendar getDate() {
        return date;
    }
    public Calendar getDatePriseRdv() {
        return datePriseRdv;
    }
    public String getDescription() {
        return description;
    }
   
    public Patient getPatient() {
        return patient;
    }

    //setters
  
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }
    public void setDate(Calendar date) {
        this.date = date;
    }
    public void setDatePriseRdv(Calendar datePriseRdv) {
        this.datePriseRdv = datePriseRdv;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
