package com.melimed.cabinet.models;
import java.util.Date;
import jakarta.persistence.*;
@Entity
@Table(name="RendezVous")
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;

    private Date date;

    private String description;
    //Foreign key
    @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
      private Patient patient;

    //constructeurs
    public RDV(){}
    public RDV(Long id, Date date, String description, Patient patient){
       this.idRdv=id;
       this.date=date;
       this.description=description;
       this.patient=patient;
    }  
    //getters
    public Long getIdRdv() {
        return idRdv;
    }
    public Date getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }

    //setters
    public void setDate(Date date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }

}
