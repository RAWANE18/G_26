package com.melimed.cabinet.models;
import jakarta.persistence.*;

@Entity
@Table(name="suiviMedical")
public class SuiviMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsuivi;


    //Foreign keys

 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name="patient" , referencedColumnName = "idPatient" )
 private Patient patient;

 @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name="fichepatient" , referencedColumnName = "idFichePatient" )
 private FichePatient fichePatient;
  

 //Constructeur
 public SuiviMedical(){}
 public SuiviMedical(Long id, Patient patient){
    this.idsuivi=id;
    this.patient=patient;
 }
 public SuiviMedical(Long id, Patient patient, FichePatient fichepatient){
    this.idsuivi=id;
    this.patient=patient;
    this.fichePatient=fichepatient;
 }

 //getters setters
 public FichePatient getFichePatient() {
     return fichePatient;
 }
 public Long getIdsuivi() {
     return idsuivi;
 }
 public Patient getPatient() {
     return patient;
 }

 public void setFichePatient(FichePatient fichePatient) {
     this.fichePatient = fichePatient;
 }
 public void setIdsuivi(Long idsuivi) {
     this.idsuivi = idsuivi;
 }
 public void setPatient(Patient patient) {
     this.patient = patient;
 }

}
