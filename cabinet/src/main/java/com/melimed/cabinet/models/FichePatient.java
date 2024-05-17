package com.melimed.cabinet.models;
import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name="fichespatients")
public class FichePatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichePatient;
    private String groupesanguin;
    private Date dateCreation;
    private String etatCivil;
    private Long securiteSociale;
    private String profession;

    //Foreign keys
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="Patient" , referencedColumnName = "idPatient" )
    private Patient patient;
  

    
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="Antecedant" , referencedColumnName = "idAntecedant" )
      private Antecedant antecedant;
    
      
     //constructeurs
  public FichePatient(){}
  public FichePatient(Long id){
    this.idFichePatient=id;
  }
 

     //setters and getters
      public Antecedant getAntecedant() {
         return antecedant;
     }
      public void setAntecedant(Antecedant antecedant) {
       this.antecedant = antecedant; 
      }
       public Patient getPatient() {
         return patient;
     }
      public void setPatient(Patient patient) {
         this.patient = patient;
     }
     public String getEtatCivil() {
         return etatCivil;
     }
     public String getProfession() {
         return profession;
     }
     public Long getSecuriteSociale() {
         return securiteSociale;
     }
     
     public void setEtatCivil(String etatCivil) {
         this.etatCivil = etatCivil;
     }
     public void setProfession(String profession) {
         this.profession = profession;
     }
     public void setSecuriteSociale(Long securiteSociale) {
         this.securiteSociale = securiteSociale;
     }
     public Long getIdFichePatient() {
         return idFichePatient;
     }
     public Date getDateCreation() {
         return dateCreation;
     }
     public String getGroupesanguin() {
         return groupesanguin;
     }

     public void setIdFichePatient(Long idFichePatient) {
         this.idFichePatient = idFichePatient;
     }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public void setGroupesanguin(String groupesanguin) {
        this.groupesanguin = groupesanguin;
    }




 }
