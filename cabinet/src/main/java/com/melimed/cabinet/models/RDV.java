package com.melimed.cabinet.models;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.*;
@Entity
@Table(name="RendezVous")
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;

    private LocalDate date;
    private LocalTime time;
	private LocalDate datePriseRdv;
	private String description;
	
    //Foreign key
    @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private Patient patient;

    //constructeurs
    public RDV(){}
    public RDV(Long id,String description, Patient patient){
       this.idRdv=id;
      
       this.description=description;
       this.patient=patient;
    }  
    //getters
    public Long getIdRdv() {
        return idRdv;
    }
   
    public LocalDate getDate() {
        return date;
    }
public LocalDate getDatePriseRdv() {
    return datePriseRdv;
}
    public LocalTime getTime() {
        return time;
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
   public void setDate(LocalDate date) {
       this.date = date;
   }
  public void setDatePriseRdv(LocalDate datePriseRdv) {
      this.datePriseRdv = datePriseRdv;
  }
   public void setTime(LocalTime time) {
       this.time = time;
   }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
